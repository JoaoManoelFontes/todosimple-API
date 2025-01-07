package com.joaomanoel.todosimple.domain.repositories;

import com.joaomanoel.todosimple.domain.models.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findById(UUID id);


    Customer register(Customer customer);

    void delete(Customer customer);
}
