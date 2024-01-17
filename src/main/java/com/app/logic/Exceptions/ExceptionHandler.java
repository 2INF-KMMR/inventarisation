package com.app.logic.Exceptions;

import java.lang.reflect.InvocationTargetException;

public class ExceptionHandler {
    protected Throwable exception = null;

    public ExceptionHandler handle(Throwable exception) {
        if (exception instanceof InvocationTargetException e) {
            this.exception = e.getTargetException();
        } else {
            this.exception = exception;
        }
        System.out.println(this.exception.getMessage());

        return this;
    }

    public boolean shouldBreak() {
        if (this.exception instanceof AbstractException e) {
            return e.shouldBreak();
        } else return false;
    }
}