package com.joaomanoel.todosimple.http.controllers;

import com.joaomanoel.todosimple.domain.usecases.AuthUseCases;
import com.joaomanoel.todosimple.http.DTOS.ResponseBuilderDTO;
import com.joaomanoel.todosimple.http.DTOS.auth.RequestLoginDTO;
import com.joaomanoel.todosimple.http.DTOS.auth.ResponseTokenDTO;
import com.joaomanoel.todosimple.http.handler.responses.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthUseCases authUseCases;

    public AuthController(AuthUseCases authUseCases) {
        this.authUseCases = authUseCases;
    }

    @PostMapping("authenticate")
    public ResponseEntity<ResponseBuilderDTO<ResponseTokenDTO>> authenticate(@Valid @RequestBody RequestLoginDTO body) {
        String token = this.authUseCases.authenticate(body.username(), body.password());
        return ResponseBuilder.build("Authorized successfully", HttpStatus.OK, new ResponseTokenDTO(token));
    }
}
