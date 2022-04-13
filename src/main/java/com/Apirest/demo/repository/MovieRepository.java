package com.Apirest.demo.repository;

import com.Apirest.demo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findMovieById(String movieId);
}
