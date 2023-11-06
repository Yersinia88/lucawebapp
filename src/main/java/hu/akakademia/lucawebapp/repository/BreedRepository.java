package hu.akakademia.lucawebapp.repository;

import hu.akakademia.lucawebapp.entity.dog.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Integer> {


}
