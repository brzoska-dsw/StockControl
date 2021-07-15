package com.pc.stockcontrol.exceptions;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super(message);
    }
}
