package com.evolution.sword.domain;

public enum ItemType {
    SWORD("Sword"),
    CLUB("Club"),
    HIDDEN("hidden");

    private final String description;


    private ItemType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}