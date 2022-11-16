package com.dcc.movie_api.controller;

import com.dcc.movie_api.data.Movie;
import com.dcc.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Integer id){
        return movieService.getById(id);
    }

    @GetMapping("/GetByGenre/{genre}")
    public List<Movie> GetMovieByGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    @GetMapping("/GetByName/{name}")
    public List<Movie> GetMovieByName(@PathVariable String name){
        return movieService.getByName(name);
    }

}
