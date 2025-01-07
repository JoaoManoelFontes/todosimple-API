package com.joaomanoel.todosimple.http.DTOS.task;

import com.joaomanoel.todosimple.domain.models.Task;

public record ResponseRegisterTaskDTO(
    Long id
){

    public ResponseRegisterTaskDTO(Task task) {
        this(task.getId());
    }
}

