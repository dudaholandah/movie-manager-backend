package br.moviemanager.backend.service;

import br.moviemanager.backend.DTO.MovieDTO;
import br.moviemanager.backend.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    Movie saveMovie(MovieDTO movieDTO);
    List<Movie> findAllMovie();
    Movie findMovieById(Long movieId);
    ResponseEntity<Movie> updateMovie(MovieDTO movieDTO, Long movieId);
    ResponseEntity<?> deleteMovie(Long movieId);

}
