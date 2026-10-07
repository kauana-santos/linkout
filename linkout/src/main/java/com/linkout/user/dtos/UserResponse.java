package com.linkout.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserResponse(
        Long id,
        String name,
        String email,
        String username,
        String profileImageUrl,
        String bio
) {
}
