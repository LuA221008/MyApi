package com.Apirest.demo.controller;

import com.Apirest.demo.model.Movie;
import com.Apirest.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MovieController{

    @Autowired
    private MovieRepository repository;

    //GET, POST, PUT, DELETE -> Http methods

    @GetMapping(value = "/")
    public List<Movie> getAllMovies(){
        return repository.findAll();
    }


    @GetMapping(value = "/{movieId}")
    public Movie findMovieById(@PathVariable String movieId) {
        return repository.findMovieById(movieId);
    }

    @PostMapping(value = "/create")
    public Movie addMovie(@RequestBody Movie movie){
        return repository.save(movie);
    }

    @PutMapping(value = "/update/{movieId}")
    public Movie updateMovie(@PathVariable String movieId, @RequestBody Movie movie){
        Movie updateMovie = repository.findById(movieId).orElseThrow(() -> {
            return new ResourceAccessException("No se encontró una pelicula con ese id");
        });
        updateMovie.setName(movie.getName());
        updateMovie.setCategory(movie.getCategory());
        updateMovie.setRating(movie.getRating());
        return repository.save(updateMovie);
    }

    @DeleteMapping(value = "/delete/{movieId}")
    public void deleteMovie(@PathVariable String movieId){
        Movie movieDeleted = repository.findById(movieId).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe esa pelicula");
        });
        repository.delete(movieDeleted);
    }

}
