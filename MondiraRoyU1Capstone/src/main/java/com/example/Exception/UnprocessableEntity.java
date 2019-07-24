package com.example.Exception;

public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity() {
    }

    public UnprocessableEntity(String message) {
        super(message);
    }
}
