package com.joaomanoel.todosimple.exceptions.task;

import com.joaomanoel.todosimple.models.Task;

public class TaskNotEmptyIdException extends RuntimeException{
    public TaskNotEmptyIdException(Task task) {
        super("O campo id deve estar vazio ao passar uma nova task para ser registrada. "+ task);
    }
}
