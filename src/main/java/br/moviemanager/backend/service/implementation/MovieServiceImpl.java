package br.moviemanager.backend.service.implementation;
import br.moviemanager.backend.DTO.MovieDTO;
import br.moviemanager.backend.model.Actor;
import br.moviemanager.backend.model.Genre;
import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.model.MovieCastKey;
import br.moviemanager.backend.repository.GenreRepository;
import br.moviemanager.backend.repository.MovieRepository;
import br.moviemanager.backend.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieRepository repository;
    @Autowired
    private GenreRepository genreRepository;

    private Movie createMovie(MovieDTO movieDTO){
        Set<Genre> genres = new HashSet<>();
        Set<String> genresTitle = movieDTO.getGenres();
        for (String title : genresTitle) {
            Genre genre = genreRepository.findGenreByTitle(title).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            genres.add(genre);
        }
        return new Movie(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getYear(), movieDTO.getTime(), movieDTO.getLanguage(), genres);
    }

    @Override
    @CacheEvict(value="movies", allEntries=true)
    public Movie saveMovie(MovieDTO movieDTO) {
        LOG.info("Adding new movie...");
        Movie movie = createMovie(movieDTO);
        return repository.save(movie);
    }

    @Override
    @Cacheable(cacheNames = "movies")
    public List<Movie> findAllMovie() {
        LOG.info("Fetching all movies...");
        return repository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "movies")
    public Movie findMovieById(Long movieId) {
        LOG.info("Fetching one movie...");
        return repository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @CacheEvict(value="movies", allEntries=true)
    public ResponseEntity<Movie> updateMovie(MovieDTO movieDTO, Long movieId) {
        LOG.info("Updating movie...");
        Movie movie = createMovie(movieDTO);
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
    @CacheEvict(value="movies", allEntries=true)
    public ResponseEntity<?> deleteMovie(Long movieId) {
        LOG.info("Deleting movie...");
        return repository.findById(movieId).map( record -> {
            repository.deleteById(movieId);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
