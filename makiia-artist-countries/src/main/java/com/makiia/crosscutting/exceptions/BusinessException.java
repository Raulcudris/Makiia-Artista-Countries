package com.makiia.crosscutting.exceptions;

public class BusinessException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public BusinessException(final String message) {
        super(message);
    }
}
