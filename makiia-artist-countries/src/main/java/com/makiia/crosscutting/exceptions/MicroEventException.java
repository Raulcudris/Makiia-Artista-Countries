package com.makiia.crosscutting.exceptions;

public class MicroEventException extends Exception {
    private static final long serialVersionUID = 1L;

    public MicroEventException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MicroEventException(final String message) {
        super(message);
    }
}
