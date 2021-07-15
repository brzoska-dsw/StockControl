package com.pc.stockcontrol.exceptions;

public class userAlreadyExistsException extends RuntimeException {
    public userAlreadyExistsException(String message) {
        super(message);
    }
}
