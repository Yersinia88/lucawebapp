package hu.akakademia.lucawebapp;

import hu.akakademia.lucawebapp.entity.dog.Breed;
import hu.akakademia.lucawebapp.populate.BreedListGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LucawebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucawebappApplication.class, args);
	}

}
