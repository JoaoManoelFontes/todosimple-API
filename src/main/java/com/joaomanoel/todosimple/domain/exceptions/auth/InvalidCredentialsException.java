package com.joaomanoel.todosimple.domain.exceptions.auth;

import java.util.UUID;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String username, String password) {
        super("Credenciais inválidas ao se autenticar! Username ("+username+") ou senha ("+password+") incorretas");
    }
}
