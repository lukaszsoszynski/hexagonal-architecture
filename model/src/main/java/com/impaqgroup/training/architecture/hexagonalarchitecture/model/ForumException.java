package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

public class ForumException extends RuntimeException {
    public ForumException() {
    }

    public ForumException(String message) {
        super(message);
    }

    public ForumException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForumException(Throwable cause) {
        super(cause);
    }

    public ForumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
