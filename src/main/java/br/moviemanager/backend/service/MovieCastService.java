package br.moviemanager.backend.service;

import br.moviemanager.backend.DTO.MovieCastDTO;
import br.moviemanager.backend.model.MovieCast;
import br.moviemanager.backend.model.MovieCastKey;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieCastService {

    MovieCast saveMovieCast(MovieCastDTO movieCastDTO);
    List<MovieCast> findAllMovieCast();
    MovieCast findMovieCastById(MovieCastKey id);
    List<MovieCast> findMovieCastByMovieId(Long movieId);
    List<MovieCast> findMovieCastByActorId(Long actorId);
    ResponseEntity<MovieCast> updateMovieCast(MovieCastDTO movieCastDTO);
    ResponseEntity<?> deleteMovieCastById(MovieCastKey id);

}
