package com.joaomanoel.todosimple.domain.exceptions.task;


public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id) {
        super("Não foi encontrada nenhuma tarefa com o id: "+id);
    }
}
