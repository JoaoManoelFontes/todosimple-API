package com.joaomanoel.todosimple.services;

import com.joaomanoel.todosimple.exceptions.customer.CustomerNotFoundException;
import com.joaomanoel.todosimple.exceptions.customer.DeleteCustomerException;
import com.joaomanoel.todosimple.exceptions.customer.CustomerNotEmptyIdException;
import com.joaomanoel.todosimple.models.Customer;
import com.joaomanoel.todosimple.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(UUID id){
        Optional<Customer> customer = this.customerRepository.findById(id);
        return customer.orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Transactional
    public Customer register(Customer customer){
        if (customer.getId() != null){
            throw new CustomerNotEmptyIdException(customer);
        }
        return this.customerRepository.save(customer);
    }

    @Transactional
    public UUID update(Customer newCustomer){
        Customer customer = this.customerRepository.findById(newCustomer.getId()).orElseThrow(() -> new CustomerNotFoundException(newCustomer.getId()));
        customer.setUsername(newCustomer.getUsername());
        customer.setPassword(newCustomer.getPassword());
        return this.customerRepository.save(customer).getId();
    }

    @Transactional
    public void delete(UUID id){
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        try {
            this.customerRepository.delete(customer);
        }catch (Exception e){
            throw new DeleteCustomerException(customer, e);
        }
    }
}
