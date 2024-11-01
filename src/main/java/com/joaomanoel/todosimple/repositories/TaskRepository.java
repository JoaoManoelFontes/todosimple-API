package com.joaomanoel.todosimple.repositories;

import com.joaomanoel.todosimple.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCustomer_Id(UUID id);
}
