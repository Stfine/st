package com.xiaoxiang.cabbate.service.sys.exception;

import org.apache.shiro.authc.AccountException;

public class UnKnowAccountException extends AccountException{

	/**
     * Creates a new UnKnowAccountException.
     */
    public UnKnowAccountException() {
        super();
    }

    /**
     * Constructs a new UnKnowAccountException.
     *
     * @param message the reason for the exception
     */
    public UnKnowAccountException(String message) {
        super(message);
    }

    /**
     * Constructs a new UnKnowAccountException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public UnKnowAccountException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new UnKnowAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public UnKnowAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
