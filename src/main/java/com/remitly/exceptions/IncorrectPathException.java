package com.remitly.exceptions;

public class IncorrectPathException extends RuntimeException {
    public IncorrectPathException(String message, Throwable error) {
        super(message, error);
    }
}
