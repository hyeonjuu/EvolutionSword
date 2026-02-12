package com.evolution.sword.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends SwordEvolutionException {
    public EntityNotFoundException(){ super("대상을 찾을 수 없습니다."); }
    public EntityNotFoundException(String message) {
        super(message);
    }
}
