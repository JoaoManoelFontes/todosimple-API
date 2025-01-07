package com.joaomanoel.todosimple.services;

import com.joaomanoel.todosimple.domain.repositories.CustomerRepository;
import com.joaomanoel.todosimple.domain.usecases.CustomerUseCases;
import com.joaomanoel.todosimple.domain.exceptions.customer.CustomerNotFoundException;
import com.joaomanoel.todosimple.domain.exceptions.customer.DeleteCustomerException;
import com.joaomanoel.todosimple.domain.exceptions.customer.CustomerNotEmptyIdException;
import com.joaomanoel.todosimple.domain.models.Customer;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerUseCases {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(UUID id){
        return this.customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer register(Customer customer){
        if (customer.getId() != null){
            throw new CustomerNotEmptyIdException(customer);
        }
        return this.customerRepository.register(customer);
    }

    public UUID update(Customer newCustomer){
        Customer customer = this.customerRepository.findById(newCustomer.getId()).orElseThrow(() -> new CustomerNotFoundException(newCustomer.getId()));
        customer.setUsername(newCustomer.getUsername());
        customer.setPassword(newCustomer.getPassword());
        return this.customerRepository.register(customer).getId();
    }

    public void delete(UUID id){
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        try {
            this.customerRepository.delete(customer);
        }catch (Exception e){
            throw new DeleteCustomerException(customer, e);
        }
    }
}
