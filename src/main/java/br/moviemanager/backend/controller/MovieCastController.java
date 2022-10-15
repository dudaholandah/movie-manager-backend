package br.moviemanager.backend.controller;

import br.moviemanager.backend.DTO.MovieCastDTO;
import br.moviemanager.backend.model.Actor;
import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.model.MovieCast;
import br.moviemanager.backend.model.MovieCastKey;
import br.moviemanager.backend.repository.MovieCastRepository;
import br.moviemanager.backend.service.MovieCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/movie-cast")
public class MovieCastController {

    @Autowired
    private MovieCastService service;

    @PostMapping
    public MovieCast save(@RequestBody MovieCastDTO movieCastDTO) {
        return service.saveMovieCast(movieCastDTO);
    }

    @GetMapping
    public List<MovieCast> findAll() {
        return service.findAllMovieCast();
    }

    @GetMapping("/id")
    public MovieCast findById(@RequestBody MovieCastKey id){
        System.out.println(id);
        return service.findMovieCastById(id);
    }

    @GetMapping("/movie/{id}")
    public List<MovieCast> findByMovieId(@PathVariable Long id){
        return service.findMovieCastByMovieId(id);
    }

    @GetMapping("/actor/{id}")
    public List<MovieCast> findByActorId(@PathVariable Long id){
        return service.findMovieCastByActorId(id);
    }

    @PutMapping
    public ResponseEntity<MovieCast> update(@RequestBody MovieCastDTO movieCastDTO){
        return service.updateMovieCast(movieCastDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody MovieCastKey id) {
        return service.deleteMovieCastById(id);
    }
    
}
