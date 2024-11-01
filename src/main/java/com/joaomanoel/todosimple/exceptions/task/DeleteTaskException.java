package com.joaomanoel.todosimple.exceptions.task;

import com.joaomanoel.todosimple.models.Task;

public class DeleteTaskException extends RuntimeException{
    public DeleteTaskException(String message) {
        super(message);
    }
    public DeleteTaskException(Task task, Exception e) {
        super("Não foi possivel excluir a tarefa em questão." + task , e);
    }
}
