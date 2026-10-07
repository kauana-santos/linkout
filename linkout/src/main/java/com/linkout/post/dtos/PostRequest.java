package com.linkout.post.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostRequest(
    @NotNull(message = "O id do autor é obrigatorio")
    Long authorId,
    @NotBlank(message = "O conteúdo do post é obrigatório")
    String content
) {
}
