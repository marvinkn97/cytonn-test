package dev.marvin.ticketbooking.email;

import org.springframework.stereotype.Component;

@Component
public interface EmailService {
    void send(String to, String subject, String content);
}
