package com.joaomanoel.todosimple.domain.usecases;

public interface PasswordEncryptionUseCases {
    String encrypt(String rawPassword);
    boolean matches(String rawPassword, String encryptedPassword);
}
