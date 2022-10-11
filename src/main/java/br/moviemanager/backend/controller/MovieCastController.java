package br.moviemanager.backend.controller;

import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.model.MovieCast;
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
    public MovieCast save(@RequestBody MovieCast movieCast) {
        return service.saveMovieCast(movieCast);
    }

    @GetMapping
    public List<MovieCast> findAll() {
        return service.findAllMovieCast();
    }

    
}
