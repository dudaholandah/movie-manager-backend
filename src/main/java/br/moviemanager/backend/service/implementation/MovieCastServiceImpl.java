package br.moviemanager.backend.service.implementation;

import br.moviemanager.backend.DTO.MovieCastDTO;
import br.moviemanager.backend.model.Actor;
import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.model.MovieCast;
import br.moviemanager.backend.model.MovieCastKey;
import br.moviemanager.backend.repository.ActorRepository;
import br.moviemanager.backend.repository.MovieCastRepository;
import br.moviemanager.backend.repository.MovieRepository;
import br.moviemanager.backend.service.MovieCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieCastServiceImpl implements MovieCastService {

    @Autowired
    private MovieCastRepository repository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    private MovieCast createMovieCast(MovieCastDTO movieCastDTO){
        MovieCastKey movieCastKey = new MovieCastKey(movieCastDTO.getActorId(), movieCastDTO.getMovieId());
        Movie movie = movieRepository.findById(movieCastDTO.getMovieId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Actor actor = actorRepository.findById(movieCastDTO.getActorId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        String character = movieCastDTO.getCharacter();
        return new MovieCast(movieCastKey, movie, actor, character);
    }

    @Override
    public MovieCast saveMovieCast(MovieCastDTO movieCastDTO){
        MovieCast movieCast = createMovieCast(movieCastDTO);
        return repository.save(movieCast);
    }

    @Override
    public List<MovieCast> findAllMovieCast() {
        return repository.findAll();
    }

    @Override
    public MovieCast findMovieCastById(MovieCastKey id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<MovieCast> findMovieCastByMovieId(Long movieId) {
        return repository.findByMovieId(movieId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<MovieCast> findMovieCastByActorId(Long actorId) {
        return repository.findByActorId(actorId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<MovieCast> updateMovieCast(MovieCastDTO movieCastDTO) {
        MovieCast movieCast = createMovieCast(movieCastDTO);
        return repository.findById(movieCast.getId()).map( record -> {
            record.setMovie(movieCast.getMovie());
            record.setActor(movieCast.getActor());
            record.setCharacter(movieCast.getCharacter());
            MovieCast updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<?> deleteMovieCastById(MovieCastKey id) {
        return repository.findById(id).map( record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
