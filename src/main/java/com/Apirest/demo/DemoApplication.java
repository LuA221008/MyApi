package com.Apirest.demo;

import com.Apirest.demo.model.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	Movie movie = new Movie("123", "300", "Action", "re mala esa vaina");

}
