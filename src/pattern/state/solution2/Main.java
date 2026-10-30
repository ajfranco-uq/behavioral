package pattern.state.solution2;


import pattern.state.solution2.domain.Order;
import pattern.state.solution2.domain.OrderItem;
import pattern.state.solution2.service.InventoryService;
import pattern.state.solution2.service.PaymentService;
import pattern.state.solution2.service.ShippingService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService(Map.of(
            "LAPTOP", 5,
            "MOUSE", 20
        ));
        PaymentService payments = new PaymentService();
        ShippingService shipping = new ShippingService();

        OrderItem laptop = new OrderItem("LAPTOP", "Laptop", 1, new BigDecimal("1200.00"));
        OrderItem mouse = new OrderItem("MOUSE", "Wireless mouse", 2, new BigDecimal("25.00"));

        System.out.println("=== Scenario 1: Successful order ===");
        Order order = new Order("ORD-1001", List.of(laptop, mouse), inventory, payments, shipping);
        printOrder(order, inventory);
        order.pay("tok_visa_demo");
        printOrder(order, inventory);
        order.ship("10 Main Street, Armenia");
        System.out.println("Tracking number: " + order.getShipment().trackingNumber());
        printOrder(order, inventory);
        order.deliver();
        printOrder(order, inventory);

        System.out.println("\n=== Scenario 2: Payment declined ===");
        Order declinedOrder = new Order("ORD-1002", List.of(mouse), inventory, payments, shipping);
        try {
            declinedOrder.pay("tok_declined");
        } catch (IllegalStateException exception) {
            System.out.println("Payment failed: " + exception.getMessage());
        }
        printOrder(declinedOrder, inventory);
        declinedOrder.cancel();
        printOrder(declinedOrder, inventory);

        System.out.println("\n=== Scenario 3: Cancel paid order and refund ===");
        Order cancelledOrder = new Order("ORD-1003", List.of(mouse), inventory, payments, shipping);
        cancelledOrder.pay("tok_visa_demo");
        cancelledOrder.cancel();
        printOrder(cancelledOrder, inventory);
        System.out.println("Was refunded: " + payments.wasRefunded("ORD-1003"));

        System.out.println("\n=== Scenario 4: Invalid operation ===");
        try {
            order.cancel();
        } catch (IllegalStateException exception) {
            System.out.println("Rejected as expected: " + exception.getMessage());
        }
    }

    private static void printOrder(Order order, InventoryService inventory) {
        System.out.printf("Order: %s | Total: %s | State: %s | Available laptops: %d | Available mice: %d%n",
            order.getOrderId(), order.getTotal(), order.getStateName(),
            inventory.availableStock("LAPTOP"), inventory.availableStock("MOUSE"));
    }
}
