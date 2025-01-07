package com.joaomanoel.todosimple.http.DTOS.task;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record RequestRegisterTaskDTO(
    @Size(min = 4, max = 50, message = "O título deve ter entre 4 e 50 caracteres.")
    @NotNull
    String title,

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    @NotNull
    String description,

    @NotNull
    UUID customerId

) {
}
