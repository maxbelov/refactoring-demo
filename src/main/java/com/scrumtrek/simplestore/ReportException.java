package com.scrumtrek.simplestore;

/**
 * Created by raz0r on 01.03.2016.
 */
public class ReportException extends Exception {
    public ReportException() {
        super();
    }

    public ReportException(String message) {
        super(message);
    }

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportException(Throwable cause) {
        super(cause);
    }

    protected ReportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
