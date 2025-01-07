package com.joaomanoel.todosimple.domain.usecases;

import com.joaomanoel.todosimple.domain.models.Task;

import java.util.List;
import java.util.UUID;

public interface TaskUseCases {
    Task findById(Long id);
    List<Task> findAllByCustomerId(UUID customerId);
    Long register(Task task);
    Long update(Task newTask);
    void delete(Long id);
}
