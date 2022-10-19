package br.moviemanager.backend.controller;

import br.moviemanager.backend.model.Actor;
import br.moviemanager.backend.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService service;

    @PostMapping
    public Actor save(@RequestBody Actor actor) {
        return service.saveActor(actor);
    }

    @GetMapping
    public List<Actor> findAll(){
        return service.findAllActor();
    }

    @GetMapping("{id}")
    public Actor findById(@PathVariable Long id){
        return service.findActorById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Actor> update(@RequestBody Actor actor, @PathVariable Long id){
        return service.updateActor(actor, id);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return service.deleteActorById(id);
    }


}
