package pattern.state.solution2.service;


import pattern.state.solution2.domain.OrderItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryService {
    private final Map<String, Integer> available = new HashMap<>();
    private final Map<String, Integer> reserved = new HashMap<>();

    public InventoryService(Map<String, Integer> initialStock) {
        initialStock.forEach((productId, quantity) -> {
            if (quantity == null || quantity < 0) {
                throw new IllegalArgumentException("Initial stock cannot be negative.");
            }
            available.put(productId, quantity);
        });
    }

    public synchronized void reserve(String orderId, List<OrderItem> items) {
        Map<String, Integer> requested = items.stream().collect(Collectors.groupingBy(
            OrderItem::productId, Collectors.summingInt(OrderItem::quantity)));
        for (Map.Entry<String, Integer> entry : requested.entrySet()) {
            int stock = available.getOrDefault(entry.getKey(), 0);
            if (stock < entry.getValue()) {
                throw new IllegalStateException("Insufficient stock for product " + entry.getKey()
                    + ". Available: " + stock + ", requested: " + entry.getValue());
            }
        }
        requested.forEach((productId, quantity) -> {
            available.put(productId, available.get(productId) - quantity);
            reserved.merge(key(orderId, productId), quantity, Integer::sum);
        });
    }

    public synchronized void release(String orderId, List<OrderItem> items) {
        Map<String, Integer> requested = items.stream().collect(Collectors.groupingBy(
            OrderItem::productId, Collectors.summingInt(OrderItem::quantity)));
        for (Map.Entry<String, Integer> entry : requested.entrySet()) {
            String reservationKey = key(orderId, entry.getKey());
            int quantity = reserved.getOrDefault(reservationKey, 0);
            if (quantity < entry.getValue()) {
                throw new IllegalStateException("No matching stock reservation for order " + orderId);
            }
        }
        requested.forEach((productId, quantity) -> {
            String reservationKey = key(orderId, productId);
            int remaining = reserved.get(reservationKey) - quantity;
            if (remaining == 0) reserved.remove(reservationKey);
            else reserved.put(reservationKey, remaining);
            available.merge(productId, quantity, Integer::sum);
        });
    }

    public synchronized int availableStock(String productId) {
        return available.getOrDefault(productId, 0);
    }

    private String key(String orderId, String productId) {
        return orderId + "::" + productId;
    }
}
