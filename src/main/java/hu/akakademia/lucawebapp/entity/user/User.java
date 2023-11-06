package hu.akakademia.lucawebapp.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private final String email;
    private final String firstName;
    private final String lastName;
    private final String password;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="registration_time")
    private LocalDateTime registrationTime;
    @Column(name="active")
    private boolean active;
    @Column(name="role")
    private Role role;

    @Override
    public String toString() {
        return String.format("%s %s (%s)", firstName, lastName, email);
    }
}
