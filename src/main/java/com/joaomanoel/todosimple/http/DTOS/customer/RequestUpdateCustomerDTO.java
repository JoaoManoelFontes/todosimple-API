package com.joaomanoel.todosimple.http.DTOS.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestUpdateCustomerDTO(
        @NotBlank(message = "O username não deve ser vazio.")
        @Size(min = 4, max = 50, message = "O username deve ter entre 4 e 50 caracteres.")
        String username,

        @NotBlank(message = "A senha não deve ser vazia.")
        @Size(min = 8, max = 50, message = "A senha deve ter entre 8 e 50 caracteres.")
        String password
) {
}
