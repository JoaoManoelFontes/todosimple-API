package com.joaomanoel.todosimple.exceptions.task;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id) {
        super("Não foi encontrado nenhuma tarefa com o id: "+id);
    }
}
