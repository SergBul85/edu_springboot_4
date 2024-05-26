package com.hstn.rest.my_controller;

public class PupilNotFoundException extends RuntimeException {

    public PupilNotFoundException(Throwable cause) {
        super(cause);
    }

    public PupilNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PupilNotFoundException(String message) {
        super(message);
    }
}
