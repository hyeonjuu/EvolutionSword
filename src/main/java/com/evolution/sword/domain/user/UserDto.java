package com.evolution.sword.domain.user;

public class UserDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User toEntity(){
        return User.builder()
                .username(this.username)
                .gold(60000L)
                .build();
    }
}
