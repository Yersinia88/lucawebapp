package hu.akakademia.lucawebapp.service;

import hu.akakademia.lucawebapp.entity.dog.Breed;

import java.util.List;

public interface BreedService {
    List<Breed> findAll();

    Breed findById(int theId);

    void save(Breed theBreed);

    void saveAll(List<Breed> breeds);
    void deleteById(int theId);


}
