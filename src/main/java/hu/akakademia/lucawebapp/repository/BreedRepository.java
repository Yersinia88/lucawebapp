package hu.akakademia.lucawebapp.repository;

import hu.akakademia.lucawebapp.entity.dog.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Integer> {


}
