package com.joaomanoel.todosimple.persistence.repositories;

import com.joaomanoel.todosimple.persistence.entities.JPACustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JPACustomerRepository extends JpaRepository<JPACustomer, UUID> {
}