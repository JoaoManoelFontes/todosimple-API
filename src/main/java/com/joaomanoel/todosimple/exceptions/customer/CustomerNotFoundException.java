package com.joaomanoel.todosimple.exceptions.customer;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(UUID id) {
        super("Não foi encontrado nenhum usuário com o id: "+id);
    }
}
