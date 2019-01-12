package com.artem.exception;

public class PossibleException extends Exception {
    public PossibleException() {
        super();
    }


    public PossibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public PossibleException(String message) {
        super(message);
    }

    public PossibleException(Throwable cause) {
        super(cause);
    }
}

