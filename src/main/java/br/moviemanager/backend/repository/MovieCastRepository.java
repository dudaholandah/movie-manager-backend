package br.moviemanager.backend.repository;

import br.moviemanager.backend.model.MovieCast;
import br.moviemanager.backend.model.MovieCastKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieCastRepository extends JpaRepository<MovieCast, MovieCastKey> {
    Optional<List<MovieCast>> findByMovieId(Long movieId);
    Optional<List<MovieCast>> findByActorId(Long actorId);
}