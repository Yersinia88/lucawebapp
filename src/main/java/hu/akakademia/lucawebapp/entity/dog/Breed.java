package hu.akakademia.lucawebapp.entity.dog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "dog_breed")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "breed_name")
    private String breedName;

    public Breed(int id, String breedName) {
        this.id = id;
        this.breedName = breedName;
    }

    public Breed() {
    }

    public Breed(String theBreedName) {
        this.breedName = theBreedName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Breed{");
        sb.append("id=").append(id);
        sb.append(", breedName='").append(breedName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}