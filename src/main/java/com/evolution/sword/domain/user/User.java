package com.evolution.sword.domain.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Long gold;

    private User(Builder builder){
        this.username = builder.username;
        this.gold = builder.gold;
    }

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

    public static class Builder{
        private String username;
        private Long gold;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder gold(Long gold){
            this.gold = gold;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}
