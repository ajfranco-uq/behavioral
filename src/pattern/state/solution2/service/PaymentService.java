package pattern.state.solution2.service;

import pattern.state.solution2.domain.PaymentReceipt;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** In-memory payment gateway simulator. Replace with a real provider in production. */
public class PaymentService {
    private final Map<String, PaymentReceipt> charges = new HashMap<>();
    private final Map<String, BigDecimal> refunds = new HashMap<>();

    public synchronized PaymentReceipt charge(String orderId, BigDecimal amount, String paymentToken) {
        if (paymentToken == null || paymentToken.isBlank()) {
            throw new IllegalArgumentException("A payment token is required.");
        }
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        if (charges.containsKey(orderId)) {
            throw new IllegalStateException("Order has already been charged: " + orderId);
        }
        if (paymentToken.equals("tok_declined")) {
            throw new IllegalStateException("Payment was declined by the provider.");
        }
        PaymentReceipt receipt = new PaymentReceipt("TXN-" + UUID.randomUUID(), amount, Instant.now());
        charges.put(orderId, receipt);
        System.out.printf("Payment captured: %s for %s%n", amount, orderId);
        return receipt;
    }

    public synchronized void refund(String orderId) {
        PaymentReceipt receipt = charges.get(orderId);
        if (receipt == null) {
            throw new IllegalStateException("Cannot refund an order that has not been charged.");
        }
        if (refunds.containsKey(orderId)) {
            throw new IllegalStateException("Order has already been refunded: " + orderId);
        }
        refunds.put(orderId, receipt.amount());
        System.out.printf("Refund processed: %s for %s%n", receipt.amount(), orderId);
    }

    public synchronized boolean wasCharged(String orderId) {
        return charges.containsKey(orderId);
    }

    public synchronized boolean wasRefunded(String orderId) {
        return refunds.containsKey(orderId);
    }
}
