package pattern.state.solution2.domain;

import java.math.BigDecimal;
import java.util.Objects;

public record OrderItem(String productId, String productName, int quantity, BigDecimal unitPrice) {
    public OrderItem {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Product ID is required.");
        }
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name is required.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        Objects.requireNonNull(unitPrice, "Unit price is required.");
        if (unitPrice.signum() < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative.");
        }
    }

    public BigDecimal lineTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
