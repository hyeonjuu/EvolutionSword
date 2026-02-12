package com.evolution.sword.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateUsernameException extends SwordEvolutionException {
    public DuplicateUsernameException(){ super("이미 존재하는 회원입니다.");}
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
