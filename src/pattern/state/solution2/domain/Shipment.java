package pattern.state.solution2.domain;

import java.time.Instant;

public record Shipment(String trackingNumber, String destination, Instant createdAt) { }
