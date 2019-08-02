package com.stackroute.exceptions;

public class TrackAlreadyExistsException extends Exception {
    private String message;

    public TrackAlreadyExistsException() {
    }

    /**Custom Exception to throw if track already exists*/
    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
