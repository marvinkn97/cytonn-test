package dev.marvin.ticketbooking.appuser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank
        @NotNull
        String fullName,

        @NotBlank
        @NotNull
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
