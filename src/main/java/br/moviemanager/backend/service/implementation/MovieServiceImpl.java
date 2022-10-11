package br.moviemanager.backend.service.implementation;

import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.repository.MovieRepository;
import br.moviemanager.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public List<Movie> findAllMovie() {
        return repository.findAll();
    }

    @Override
    public Movie findMovieById(Long movieId) {
        return repository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Movie> updateMovie(Movie movie, Long movieId) {
        return repository.findById(movieId).map( record -> {
            record.setTitle(movie.getTitle());
            record.setYear(movie.getYear());
            record.setTime(movie.getTime());
            record.setLanguage(movie.getLanguage());
            Movie updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<?> deleteMovie(Long movieId) {
        return repository.findById(movieId).map( record -> {
            repository.deleteById(movieId);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
