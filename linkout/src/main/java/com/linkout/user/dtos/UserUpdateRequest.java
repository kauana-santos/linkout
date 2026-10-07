package com.linkout.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(

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
