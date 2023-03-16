package com.makiia.crosscutting.exceptions;

import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.exceptions.Main.EBusinessSystemException;

public class ExceptionBuilder {
    private String code;
    private String message;
    private Throwable parentException;

    private ExceptionBuilder() {
    }

    public static ExceptionBuilder builder() {
        return new ExceptionBuilder();
    }

    public ExceptionBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public ExceptionBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ExceptionBuilder(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ExceptionBuilder withParentException(Throwable parentException) {
        this.parentException = parentException;
        return this;
    }

    public EBusinessException buildBusinessException() {
        return this.code == null ? new EBusinessException(this.message, this.parentException) : new EBusinessException(this.message, this.parentException, this.code);
    }

    public EBusinessSystemException buildSystemException() {
        return this.code == null ? new EBusinessSystemException(this.message, this.parentException) : new EBusinessSystemException(this.message, this.parentException, this.code);
    }


}
