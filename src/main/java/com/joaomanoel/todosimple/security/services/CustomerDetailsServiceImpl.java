package com.joaomanoel.todosimple.security.services;

import com.joaomanoel.todosimple.domain.exceptions.customer.CustomerNotFoundException;
import com.joaomanoel.todosimple.domain.repositories.CustomerRepository;
import com.joaomanoel.todosimple.security.entities.CustomerAuthenticated;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public CustomerDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customerRepository.findByUsername(username)
                .map(CustomerAuthenticated::new)
                .orElseThrow(
                        () -> new CustomerNotFoundException(username));

    }
}
