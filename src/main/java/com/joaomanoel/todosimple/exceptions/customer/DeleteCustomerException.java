package com.joaomanoel.todosimple.exceptions.customer;

import com.joaomanoel.todosimple.models.Customer;

public class DeleteCustomerException extends RuntimeException{
    public DeleteCustomerException(String message) {
        super(message);
    }

    public DeleteCustomerException(Customer customer, Exception e) {
        super("Não foi possivel excluir o usuário em questão." + customer , e);
    }
}
