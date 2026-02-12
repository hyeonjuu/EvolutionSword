package com.evolution.sword.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientGoldException extends SwordEvolutionException {

    public InsufficientGoldException(){
        super("골드가 부족합니다.");
    }

    public InsufficientGoldException(String message) {
        super(message);
    }
}
