package dev.marvin.ticketbooking.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public record EventDto(
        @NotBlank
        @NotNull
        String name,

        @NotBlank
        @NotNull
        LocalDateTime startDate,

        @NotBlank
        @NotNull
        LocalDateTime endDate,

        @NotBlank
        @NotNull
        String location,

        @NotNull
        Integer capacity,

        @NotBlank
        @NotNull
        MultipartFile imageFile,

        @NotBlank
        @NotNull
        String host,

        @NotBlank
        @NotNull
        String description) {
}