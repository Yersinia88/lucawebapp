package hu.akakademia.lucawebapp.populate;

import hu.akakademia.lucawebapp.entity.dog.Breed;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BreedListGenerator {
    public List<Breed> fillBreedList(String filename) {
        List<Breed> breeds = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Breed tempBreed = new Breed(1, line.strip());
                breeds.add(tempBreed);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return breeds;
    }

}
