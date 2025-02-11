package dev.atilioaraujo.workflow.model.core;

import java.math.BigDecimal;
import java.util.Map;

public record ProductRequest(
        long id,
        BigDecimal price,
        int amount
) {
    public Map<String, Object> toMap() {
        return Map.of(
                "id", id,
                "price", price,
                "amount", amount
        );
    }
}
