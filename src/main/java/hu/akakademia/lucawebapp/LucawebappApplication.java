package hu.akakademia.lucawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LucawebappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext apc = SpringApplication.run(LucawebappApplication.class, args);
		for (String s:apc.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}

}
