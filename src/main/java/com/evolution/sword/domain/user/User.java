package com.evolution.sword.domain;

public class User {
    private Long id;
    private String username;
    private Long gold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public void useGold(Long cost){
        this.gold -= cost;
    }


}
