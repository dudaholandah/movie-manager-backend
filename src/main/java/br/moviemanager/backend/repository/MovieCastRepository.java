package br.moviemanager.backend.repository;

import br.moviemanager.backend.model.MovieCast;
import br.moviemanager.backend.model.MovieCastKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCastRepository extends JpaRepository<MovieCast, MovieCastKey> {
}