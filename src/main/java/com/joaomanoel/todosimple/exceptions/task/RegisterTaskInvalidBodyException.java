package com.joaomanoel.todosimple.exceptions.task;

public class RegisterTaskInvalidBodyException extends RuntimeException{
    public RegisterTaskInvalidBodyException(String message) {
        super(message);
    }
}
