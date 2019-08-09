package com.stackroute.exceptions;

/**
 * Custom Exception to throw if database connection is lost
 */
public class DatabaseConnectionFailException extends Exception {
    private String message;

    public DatabaseConnectionFailException() {
    }

    public DatabaseConnectionFailException(String message) {
        super(message);
        this.message = message;
    }
}
