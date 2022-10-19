package br.moviemanager.backend.service.implementation;

import br.moviemanager.backend.model.Genre;
import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.repository.GenreRepository;
import br.moviemanager.backend.repository.MovieRepository;
import br.moviemanager.backend.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository repository;

    @Override
    public Genre saveGenre(Genre Genre) {
        return null;
    }

    @Override
    public List<Genre> findAllGenre() {
        return repository.findAll();
    }

    @Override
    public Genre findGenreById(Long genreId) {
        return repository.findById(genreId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Genre> updateGenre(Genre genre, Long genreId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteGenre(Long genreId) {
        return null;
    }
}
