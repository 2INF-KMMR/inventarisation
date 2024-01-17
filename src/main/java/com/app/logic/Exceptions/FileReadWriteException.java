package com.app.logic.Exceptions;

public class FileReadWriteException extends AbstractException {
    public FileReadWriteException(String message) {
        super(message);
    }
    public boolean shouldBreak() {
        return true;
    }
}
