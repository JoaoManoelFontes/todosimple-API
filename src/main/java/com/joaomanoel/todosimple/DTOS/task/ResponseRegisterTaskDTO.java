package com.joaomanoel.todosimple.DTOS.task;

import com.joaomanoel.todosimple.models.Task;

public record ResponseRegisterTaskDTO(
    Long id
){

    public ResponseRegisterTaskDTO(Task task) {
        this(task.getId());
    }
}

