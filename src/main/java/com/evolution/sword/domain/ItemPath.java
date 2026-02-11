package com.evolution.sword.domain;

import jakarta.persistence.*;

@Entity
public class ItemPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String pathCode;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private String name;

    private String description;
}
