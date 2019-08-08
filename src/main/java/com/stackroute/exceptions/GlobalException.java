package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @ControllerAdvice annotation provided by Spring allows you to write global
 * code that can be applied to a wide range of controllers
 */
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    /**
     * Handles exception thrown by service class
     */
    @ExceptionHandler(value = TrackNotFoundException.class)
    public ResponseEntity<Object> notFoundException(TrackNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TrackAlreadyExistsException.class)
    public ResponseEntity<Object> alreadyExistsException(TrackAlreadyExistsException exception) {
        return new ResponseEntity<>("Track already exists", HttpStatus.CONFLICT);
    }

    /**
     * Handles Internal_Server_Error i.e if database connection fails
     */
    @ExceptionHandler(value = HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> internalServerError(HttpServerErrorException.InternalServerError exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
