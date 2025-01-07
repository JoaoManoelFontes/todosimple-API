package com.joaomanoel.todosimple.http.DTOS.task;

import com.joaomanoel.todosimple.domain.models.Task;

public record ResponseTasksByCustomerDTO (
        Long id,
        String title,
        String description
){
    public ResponseTasksByCustomerDTO (Task task){
        this(task.getId(), task.getTitle(), task.getDescription());
    }
}
