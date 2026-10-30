package pattern.state.solution2.domain;

import java.math.BigDecimal;
import java.time.Instant;

public record PaymentReceipt(String transactionId, BigDecimal amount, Instant createdAt) { }
