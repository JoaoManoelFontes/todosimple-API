package com.joaomanoel.todosimple.security.services;

import com.joaomanoel.todosimple.domain.usecases.PasswordEncryptionUseCases;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptPasswordEncryptionService implements PasswordEncryptionUseCases {

    private final BCryptPasswordEncoder delegate = new BCryptPasswordEncoder();

    @Override
    public String encrypt(String rawPassword) {
        return delegate.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encryptedPassword) {
        return delegate.matches(rawPassword, encryptedPassword);
    }
}
