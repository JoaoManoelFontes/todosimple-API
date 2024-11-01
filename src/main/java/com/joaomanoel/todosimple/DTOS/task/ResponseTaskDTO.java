package com.joaomanoel.todosimple.DTOS.task;

import com.joaomanoel.todosimple.models.Customer;
import com.joaomanoel.todosimple.models.Task;

public record ResponseTaskDTO(
        Long id,
        String title,
        String description,
        Customer customer
) {
    public ResponseTaskDTO(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getCustomer());
    }
}
