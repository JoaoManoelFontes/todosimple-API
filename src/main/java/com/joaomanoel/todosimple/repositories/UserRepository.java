package com.joaomanoel.todosimple.repositories;

import com.joaomanoel.todosimple.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Customer, UUID> {
}
