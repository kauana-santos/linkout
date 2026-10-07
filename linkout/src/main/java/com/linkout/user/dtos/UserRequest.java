package com.linkout.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @Size(min = 3, max = 30, message = "O username deve ter entre 3 a 30 caracteres")
        @NotBlank(message = "O username é obrigatorio")
        String username,

        @Size(max = 100)
        @NotBlank(message = "O name é obrigatorio")
        String name,

        @Size(max = 500)
        String bio,

        @Email(message = "e-mail inválido")
        @NotBlank(message = "O e-mail é obrigatorio")
        @Size(max = 150)
        String email
) {
}
