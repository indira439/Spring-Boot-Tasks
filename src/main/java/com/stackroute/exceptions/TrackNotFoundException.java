package com.stackroute.exceptions;

/**
 * Custom Exception to throw if track is not found
 */
public class TrackNotFoundException {
    private String message;

    public TrackNotFoundException() {
    }


    public TrackNotFoundException(String message) {
        this.message = message;
    }
}
