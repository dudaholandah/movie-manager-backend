package br.moviemanager.backend.service;

import br.moviemanager.backend.model.MovieCast;

import java.util.List;

public interface MovieCastService {

    MovieCast saveMovieCast(MovieCast moviecast);
    List<MovieCast> findAllMovieCast();

}
