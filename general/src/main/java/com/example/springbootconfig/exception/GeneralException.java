package com.example.springbootconfig.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralException extends RuntimeException{
    private final String code;
    public GeneralException(String code) {
        this.code = code;
    }
}
