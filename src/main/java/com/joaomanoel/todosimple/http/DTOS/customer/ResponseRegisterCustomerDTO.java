package com.joaomanoel.todosimple.http.DTOS.customer;

import com.joaomanoel.todosimple.domain.models.Customer;

import java.util.UUID;

public record ResponseRegisterCustomerDTO(
        UUID id
){
    public ResponseRegisterCustomerDTO(Customer customer){
        this(customer.getId());
    }
}
