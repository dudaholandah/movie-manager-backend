package br.moviemanager.backend.controller;

import br.moviemanager.backend.model.Genre;
import br.moviemanager.backend.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping()
    public List<Genre> findAll(){
        return service.findAllGenre();
    }

    @GetMapping("{id}")
    public Genre findById(@PathVariable Long id){
        return service.findGenreById(id);
    }

}
