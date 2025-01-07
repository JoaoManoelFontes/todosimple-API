package com.joaomanoel.todosimple.domain.exceptions.customer;

import com.joaomanoel.todosimple.domain.models.Customer;

public class CustomerNotEmptyIdException extends RuntimeException{

    public CustomerNotEmptyIdException(Customer customer) {
        super("O campo id deve estar vazio ao passar um novo usuário para ser registrado. "+ customer);
    }
}
