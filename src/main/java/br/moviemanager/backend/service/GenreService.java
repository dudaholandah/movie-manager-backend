package br.moviemanager.backend.service;

import br.moviemanager.backend.model.Genre;
import br.moviemanager.backend.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {

    Genre saveGenre(Genre genre);
    List<Genre> findAllGenre();
    Genre findGenreById(Long genreId);
    ResponseEntity<Genre> updateGenre(Genre genre, Long genreId);
    ResponseEntity<?> deleteGenre(Long genreId);

}
