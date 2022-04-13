package com.Apirest.demo.controller;

import com.Apirest.demo.model.Movie;
import com.Apirest.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        movie.setId(movieId);
        return repository.save(movie);
    }

    @DeleteMapping(value = "/delete/{movieId}")
    public void deleteMovie(@PathVariable String movieId){
        repository.deleteById(movieId);
    }



}
