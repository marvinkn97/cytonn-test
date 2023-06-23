package dev.marvin.ticketbooking.appuser;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class AppUser {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
