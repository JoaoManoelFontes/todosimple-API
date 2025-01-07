package com.joaomanoel.todosimple.http.handler.responses;

import com.joaomanoel.todosimple.http.DTOS.ResponseBuilderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    public static <T> ResponseEntity<ResponseBuilderDTO<T>> build(String message, HttpStatus status, T responseObj) {
        ResponseBuilderDTO<T> response = new ResponseBuilderDTO<>(message, status.value(), responseObj);
        return new ResponseEntity<>(response, status);
    }
}
