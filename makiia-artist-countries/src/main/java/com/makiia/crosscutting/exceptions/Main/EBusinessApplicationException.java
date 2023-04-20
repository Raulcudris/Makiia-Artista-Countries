package com.makiia.crosscutting.exceptions.Main;

public class EBusinessApplicationException extends Exception {
    private static final long serialVersionUID = 1L;
    private String code;

    public EBusinessApplicationException(String message) {
        super(message);
    }

    public EBusinessApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public boolean isBusinessException() {
        return this instanceof EBusinessException;
    }

    public boolean isSystemException() {
        return this instanceof EBusinessSystemException;
    }

    public EBusinessApplicationException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
