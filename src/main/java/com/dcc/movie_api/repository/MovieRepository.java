package com.dcc.movie_api.repository;

import com.dcc.movie_api.data.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public List<Movie> GetByGenre(String genre);
    public List<Movie> GetByName(String name);
}