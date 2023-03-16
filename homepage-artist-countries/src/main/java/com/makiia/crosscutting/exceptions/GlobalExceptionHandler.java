package com.makiia.crosscutting.exceptions;

import com.makiia.crosscutting.exceptions.Main.EBusinessApplicationException;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;

import com.makiia.crosscutting.domain.model.exceptions.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EBusinessApplicationException.class)
    public ResponseEntity<?> handleHomepageArtistApplicationException(EBusinessApplicationException exception,
                                                                 WebRequest request) {
        return new ResponseEntity<>(ErrorDetails.builder()
                .message(exception.getMessage())
                .code(exception.getCode())
                .timestamp(new Date())
                .build(), this.getCode(exception));
    }

    @ExceptionHandler(EBusinessException.class)
    public ResponseEntity<?> handleEBusinessException(EBusinessException exception, WebRequest request) {
        return new ResponseEntity<>(ErrorDetails.builder()
                .message(exception.getMessage())
                .code(exception.getCode())
                .timestamp(new Date())
                .build(), this.getCode(exception));
    }

    private HttpStatus getCode(EBusinessApplicationException exception) {
        try {
            return HttpStatus.valueOf(Integer.parseInt(exception.getCode()));
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    private HttpStatus getCode(EBusinessException exception) {
        try {
            return HttpStatus.valueOf(Integer.parseInt(exception.getCode()));
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
