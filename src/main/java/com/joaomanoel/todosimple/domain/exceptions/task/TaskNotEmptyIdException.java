package com.joaomanoel.todosimple.domain.exceptions.task;

import com.joaomanoel.todosimple.domain.models.Task;

public class TaskNotEmptyIdException extends RuntimeException{
    public TaskNotEmptyIdException(Task task) {
        super("O campo id deve estar vazio ao passar uma nova task para ser registrada. "+ task);
    }
}
