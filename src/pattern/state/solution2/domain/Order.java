package pattern.state.solution2.domain;

import pattern.state.solution2.service.InventoryService;
import pattern.state.solution2.service.PaymentService;
import pattern.state.solution2.service.ShippingService;
import pattern.state.solution2.state.CreatedState;
import pattern.state.solution2.state.OrderState;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Order {
    private final String orderId;
    private final List<OrderItem> items;
    private final BigDecimal total;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private OrderState state;
    private PaymentReceipt paymentReceipt;
    private Shipment shipment;

    public Order(String orderId, List<OrderItem> items,
                 InventoryService inventoryService,
                 PaymentService paymentService,
                 ShippingService shippingService) {
        if (orderId == null || orderId.isBlank()) throw new IllegalArgumentException("Order ID is required.");
        if (items == null || items.isEmpty()) throw new IllegalArgumentException("An order must contain at least one item.");
        this.orderId = orderId;
        this.items = List.copyOf(items);
        this.inventoryService = Objects.requireNonNull(inventoryService);
        this.paymentService = Objects.requireNonNull(paymentService);
        this.shippingService = Objects.requireNonNull(shippingService);
        this.total = this.items.stream().map(OrderItem::lineTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.state = new CreatedState();
        this.inventoryService.reserve(orderId, this.items);
    }

    public void pay(String paymentToken) { state.pay(this, paymentToken); }
    public void ship(String destination) { state.ship(this, destination); }
    public void deliver() { state.deliver(this); }
    public void cancel() { state.cancel(this); }

    public String getOrderId() { return orderId; }
    public List<OrderItem> getItems() { return items; }
    public BigDecimal getTotal() { return total; }
    public String getStateName() { return state.getName(); }
    public PaymentReceipt getPaymentReceipt() { return paymentReceipt; }
    public Shipment getShipment() { return shipment; }

    // Package-level state transition operations: called by concrete state classes.
    public void changeState(OrderState newState) {
        this.state = Objects.requireNonNull(newState);
        System.out.printf("Order %s state -> %s%n", orderId, state.getName());
    }

    public void capturePayment(String paymentToken) {
        this.paymentReceipt = paymentService.charge(orderId, total, paymentToken);
    }

    public void refundPayment() {
        paymentService.refund(orderId);
    }

    public void releaseInventory() {
        inventoryService.release(orderId, items);
    }

    public void createShipment(String destination) {
        this.shipment = shippingService.createShipment(orderId, destination);
    }

    public void confirmDelivery() {
        shippingService.markDelivered(orderId);
    }
}
