package br.moviemanager.backend.controller;

import br.moviemanager.backend.DTO.MovieDTO;
import br.moviemanager.backend.model.Movie;
import br.moviemanager.backend.service.MovieService;
import br.moviemanager.backend.service.implementation.MovieServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService service;

    @PostMapping
    public Movie save(@RequestBody MovieDTO movieDTO) {
        LOG.info("Request 'save' received to the controller!");
        return service.saveMovie(movieDTO);
    }

    @GetMapping
    public List<Movie> findAll(){
        LOG.info("Request 'find_all' received to the controller!");
        return service.findAllMovie();
    }

    @GetMapping("{id}")
    public Movie findById(@PathVariable Long id) {
        LOG.info("Request 'find_by_id' received to the controller!");
        return service.findMovieById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> update(@RequestBody MovieDTO movieDTO, @PathVariable Long id){
        LOG.info("Request 'update' received to the controller!");
        return service.updateMovie(movieDTO, id);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        LOG.info("Request 'delete' received to the controller!");
        return service.deleteMovie(id);
    }

}
