package pattern.state.solution2.service;

import pattern.state.solution2.domain.Shipment;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** In-memory shipping provider simulator. */
public class ShippingService {
    private final Map<String, Shipment> shipments = new HashMap<>();
    private final Map<String, Boolean> delivered = new HashMap<>();

    public synchronized Shipment createShipment(String orderId, String destination) {
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("A shipping destination is required.");
        }
        if (shipments.containsKey(orderId)) {
            throw new IllegalStateException("A shipment already exists for " + orderId);
        }
        Shipment shipment = new Shipment("TRK-" + UUID.randomUUID(), destination, Instant.now());
        shipments.put(orderId, shipment);
        delivered.put(orderId, false);
        System.out.printf("Shipment created: %s, destination: %s%n", shipment.trackingNumber(), destination);
        return shipment;
    }

    public synchronized void markDelivered(String orderId) {
        if (!shipments.containsKey(orderId)) {
            throw new IllegalStateException("No shipment exists for order " + orderId);
        }
        if (Boolean.TRUE.equals(delivered.get(orderId))) {
            throw new IllegalStateException("Shipment is already delivered.");
        }
        delivered.put(orderId, true);
        System.out.println("Carrier confirmed delivery for " + orderId);
    }

    public synchronized Shipment findShipment(String orderId) {
        return shipments.get(orderId);
    }
}
