package com.joaomanoel.todosimple.exceptions.customer;

import com.joaomanoel.todosimple.models.Customer;

public class CustomerNotEmptyIdException extends RuntimeException{

    public CustomerNotEmptyIdException(Customer customer) {
        super("O campo id deve estar vazio ao passar um novo usuário para ser registrado. "+ customer);
    }
}
