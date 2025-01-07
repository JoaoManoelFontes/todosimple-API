package com.joaomanoel.todosimple.http.DTOS;

public record ResponseBuilderDTO<T>(
        String message,
        int status,
        T data
) {
    public ResponseBuilderDTO {
    }
}
