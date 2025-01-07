package com.joaomanoel.todosimple.domain.repositories;

import com.joaomanoel.todosimple.domain.models.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    Optional<Task> findById(Long id);
    List<Task> findAllByCustomer_Id(UUID customerId);
    Task save(Task task);
    void delete(Task task);
}
