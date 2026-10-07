package com.linkout.post.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostUpdateRequest(
    @NotBlank(message = "O conteúdo do post é obrigatório")
    String content
) {
}
