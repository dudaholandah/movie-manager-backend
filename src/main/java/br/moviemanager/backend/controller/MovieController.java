package br.moviemanager.backend.controller;

import br.moviemanager.backend.DTO.MovieDTO;
import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping
    public Movie save(@RequestBody MovieDTO movieDTO) {
        return service.saveMovie(movieDTO);
    }

    @GetMapping
    public List<Movie> findAll(){
        return service.findAllMovie();
    }

    @GetMapping("{id}")
    public Movie findById(@PathVariable Long id) {
        return service.findMovieById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> update(@RequestBody MovieDTO movieDTO, @PathVariable Long id){
        return service.updateMovie(movieDTO, id);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return service.deleteMovie(id);
    }

}
