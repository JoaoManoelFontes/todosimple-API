package com.joaomanoel.todosimple.http.DTOS.customer;

import com.joaomanoel.todosimple.domain.models.Customer;

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
