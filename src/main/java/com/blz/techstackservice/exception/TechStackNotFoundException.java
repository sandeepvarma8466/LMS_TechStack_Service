package com.blz.techstackservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class TechStackNotFoundException extends RuntimeException {
    private int statuscode;
    private String message;

    public TechStackNotFoundException(String message, int statuscode) {
        super(message);
        this.statuscode = statuscode;
        this.message = message;
    }
}
