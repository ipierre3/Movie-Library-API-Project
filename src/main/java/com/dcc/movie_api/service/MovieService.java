package com.dcc.movie_api.service;

import com.dcc.movie_api.data.Movie;
import com.dcc.movie_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getByGenre(String genre) {
        return movieRepository.GetByGenre(genre);
    }

    public List<Movie> getByName(String name) {
        return movieRepository.GetByName(name);
    }


    public void deleteMovieById(Integer id) {
        movieRepository.deleteById(id);
    }


    public Movie updateMovieById(Integer id, Movie movieData){
        Movie movieToUpdate = movieRepository.findById(id).orElse(null);
        movieToUpdate.setName(movieData.getName());
        movieToUpdate.setGenre(movieData.getGenre());
        movieToUpdate.setDirector(movieData.getDirector());
        movieRepository.save(movieToUpdate);

        return movieToUpdate;
    }

}