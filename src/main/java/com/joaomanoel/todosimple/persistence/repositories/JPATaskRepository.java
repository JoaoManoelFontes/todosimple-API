package com.joaomanoel.todosimple.persistence.repositories;

import com.joaomanoel.todosimple.persistence.entities.JPATask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JPATaskRepository extends JpaRepository<JPATask, Long> {
    List<JPATask> findAllByCustomer_Id(UUID id);
}
