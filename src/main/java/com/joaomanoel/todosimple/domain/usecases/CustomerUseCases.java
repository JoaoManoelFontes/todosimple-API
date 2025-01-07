package com.joaomanoel.todosimple.domain.usecases;

import com.joaomanoel.todosimple.domain.models.Customer;

import java.util.UUID;

public interface CustomerUseCases {
    Customer findById(UUID id);
    Customer register(Customer customer);
    UUID update(Customer newCustomer);
    void delete(UUID id);
}
