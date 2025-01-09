package com.joaomanoel.todosimple.security.services;

import com.joaomanoel.todosimple.domain.exceptions.auth.InvalidCredentialsException;
import com.joaomanoel.todosimple.domain.usecases.AuthUseCases;
import com.joaomanoel.todosimple.domain.usecases.PasswordEncryptionUseCases;
import com.joaomanoel.todosimple.domain.usecases.TokenGeneratorUseCases;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthUseCases {
    private final TokenGeneratorUseCases tokenGeneratorUseCases;
    private final PasswordEncryptionUseCases passwordEncryptionUseCases;
    private final UserDetailsService userDetailsService;

    public AuthService(TokenGeneratorUseCases tokenGeneratorUseCases, PasswordEncryptionUseCases passwordEncryptionUseCases, UserDetailsService userDetailsService) {
        this.tokenGeneratorUseCases = tokenGeneratorUseCases;
        this.passwordEncryptionUseCases = passwordEncryptionUseCases;
        this.userDetailsService = userDetailsService;
    }

    public String authenticate(String username, String password){
        UserDetails customer = this.userDetailsService.loadUserByUsername(username);
        if(!this.passwordEncryptionUseCases.matches(password, customer.getPassword())){
            throw new InvalidCredentialsException(username,password);
        }

        return tokenGeneratorUseCases.genToken(customer.getUsername());

    }
}
