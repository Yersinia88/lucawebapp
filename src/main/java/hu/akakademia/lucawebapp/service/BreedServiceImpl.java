package hu.akakademia.lucawebapp.service;

import hu.akakademia.lucawebapp.entity.dog.Breed;
import hu.akakademia.lucawebapp.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService {
    BreedRepository breedRepository;

    @Autowired
    public BreedServiceImpl(BreedRepository theBreedRepository) {
        this.breedRepository = theBreedRepository;
    }

    @Override
    public List<Breed> findAll() {
        return breedRepository.findAll();
    }

    @Override
    public Breed findById(int theId) {
        Optional<Breed> result = breedRepository.findById(theId);
        Breed breed;

        if (result.isPresent()) {
            breed = result.get();
        } else {
            throw new RuntimeException("Nincs ilyen azonosítójú kutyafajta + " + theId);
        }
        return breed;
    }

    @Override
    public void save(Breed theBreed) {
        breedRepository.save(theBreed);

    }

    @Override
    public void saveAll(List<Breed> breeds) {
        breedRepository.saveAll(breeds);
    }

    @Override
    public void deleteById(int theId) {
        breedRepository.deleteById(theId);
    }


    @Override
    public void deleteAll() {
        breedRepository.deleteAll();
    }
}
