package com.makiia.crosscutting.exceptions;

public class TraceabilityException extends Exception {
    private static final long serialVersionUID = 1L;

    public TraceabilityException(final String message) {
        super(message);
    }
}
