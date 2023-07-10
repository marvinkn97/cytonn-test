package dev.marvin.ticketbooking.appuser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank
        @NotNull
        String fullName,

        @NotBlank
        @NotNull
        @Email(regexp = "/&#40;[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9._-]+&#41;/g")
        String email,

        @NotBlank
        @NotNull
        String password,

        @NotBlank
        @NotNull
        String phoneNumber,

        @NotBlank
        @NotNull
        String address
) {
}
