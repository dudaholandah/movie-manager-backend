package br.moviemanager.backend.service;

import br.moviemanager.backend.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);
    List<Movie> findAllMovie();
    Movie findMovieById(Long movieId);
    ResponseEntity<Movie> updateMovie(Movie movie, Long movieId);
    ResponseEntity<?> deleteMovie(Long movieId);

}
