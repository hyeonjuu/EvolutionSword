package com.evolution.sword.domain;

import jakarta.persistence.*;

@Entity
public class EnhancementRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private Integer targetLevel;

    private Double successRate;

    private Long cost;

    public Long getCost() {
        return cost;
    }

    public Double getSuccessRate() {
        return successRate;
    }
}
