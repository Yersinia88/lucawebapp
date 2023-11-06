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
public class UserComment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private final int id;
    @Column(name="user_id")
    private final int userID;
    @Column(name="dog_id")
    private final int dogId;
    @Column(name="user_comment")
    private final String userComment;
    @Column(name="user_comment_timestamp")
    private LocalDateTime date;
}