package com.joaomanoel.todosimple.persistence.repositories;

import com.joaomanoel.todosimple.domain.models.Customer;
import com.joaomanoel.todosimple.persistence.entities.JPACustomer;
import com.joaomanoel.todosimple.domain.repositories.CustomerRepository;
import com.joaomanoel.todosimple.utils.CustomerMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JPACustomerRepository jpaCustomerRepository;
    private final CustomerMapper customerMapper;

    public CustomerRepositoryImpl(JPACustomerRepository jpaCustomerRepository, CustomerMapper customerMapper) {
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        Optional<JPACustomer> jpaCustomer = this.jpaCustomerRepository.findById(id);
        return jpaCustomer.map(this.customerMapper::EntityToDomain);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        Optional<JPACustomer> jpaCustomer = this.jpaCustomerRepository.findByUsername(username);
        return jpaCustomer.map(this.customerMapper::EntityToDomain);
    }

    @Override
    @Transactional
    public Customer register(Customer customer) {
        JPACustomer jpaCustomer = this.jpaCustomerRepository.save(this.customerMapper.DomainToEntity(customer));
        return this.customerMapper.EntityToDomain(jpaCustomer);
    }

    @Override
    @Transactional
    public void delete(Customer customer) {
        this.jpaCustomerRepository.delete(this.customerMapper.DomainToEntity(customer));
    }
}
