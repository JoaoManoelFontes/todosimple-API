package com.joaomanoel.todosimple.DTOS.customer;

import com.joaomanoel.todosimple.models.Customer;

import java.util.UUID;

public record ResponseRegisterCustomerDTO(
        UUID id
){
    public ResponseRegisterCustomerDTO(Customer customer){
        this(customer.getId());
    }
}
