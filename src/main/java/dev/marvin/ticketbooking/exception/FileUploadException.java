package dev.marvin.ticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
public class FileUploadException extends RuntimeException{
    public FileUploadException(String message) {
        super(message);
    }
}
