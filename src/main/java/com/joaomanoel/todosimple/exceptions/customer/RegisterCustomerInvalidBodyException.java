package com.joaomanoel.todosimple.exceptions.customer;

public class RegisterCustomerInvalidBodyException extends RuntimeException{

    public RegisterCustomerInvalidBodyException(String message) {
        super(message);
    }
}
