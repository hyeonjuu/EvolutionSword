package com.evolution.sword.domain;

import jakarta.persistence.*;

@Entity
public class ItemMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "path_id")
    private ItemPath itemPath;

    private Integer enhancementLevel;

    public Integer getEnhancementLevel() {
        return enhancementLevel;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
