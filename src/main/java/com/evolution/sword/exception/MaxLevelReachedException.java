package com.evolution.sword.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaxLevelReachedException extends SwordEvolutionException {
    public MaxLevelReachedException(){super("이미 최대 강화 레벨에 도달하였습니다.");}
    public MaxLevelReachedException(String message) {
        super(message);
    }
}
