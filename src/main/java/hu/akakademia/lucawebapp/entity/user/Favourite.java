package hu.akakademia.lucawebapp.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Favourite {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private final int id;
    @Column(name="dog_id")
    private final int dogId;
    @Column(name="user_id")
    private final int userId;
    @Column(name="my_favourtie")
    private final boolean myFavourite;
}
