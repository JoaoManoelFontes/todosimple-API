package com.joaomanoel.todosimple.DTOS.customer;

import com.joaomanoel.todosimple.models.Customer;

import java.util.UUID;

public record ResponseCustomerDTO(
        UUID id,
        String username,
        String email
) {

    public ResponseCustomerDTO(Customer customer) {
        this(customer.getId(), customer.getUsername(), customer.getEmail());
    }
}
