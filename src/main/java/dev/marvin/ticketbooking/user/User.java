package dev.marvin.ticketbooking.user;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class User {
    @Id
    @SequenceGenerator(name = "user_id_sequence", sequenceName = "user_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;
}
