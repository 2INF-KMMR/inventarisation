package com.app.logic.Exceptions;

abstract public class AbstractException extends Exception  {
    public AbstractException(String message) {super (message);}
    public boolean shouldBreak() {
        return false;
    }

}
