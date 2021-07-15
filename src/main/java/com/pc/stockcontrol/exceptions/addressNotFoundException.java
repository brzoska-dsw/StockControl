package com.pc.stockcontrol.exceptions;

public class addressNotFoundException extends RuntimeException {
    public addressNotFoundException(String message) {
        super(message);
    }
}
