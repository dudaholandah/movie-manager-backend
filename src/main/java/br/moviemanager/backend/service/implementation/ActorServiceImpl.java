package br.moviemanager.backend.service.implementation;

import br.moviemanager.backend.model.Actor;
import br.moviemanager.backend.repository.ActorRepository;
import br.moviemanager.backend.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository repository;

    @Override
    public Actor saveActor(Actor actor) {
        return repository.save(actor);
    }

    @Override
    public List<Actor> findAllActor() {
        return repository.findAll();
    }

    @Override
    public Actor findActorById(Long actorId) {
        return repository.findById(actorId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Actor> updateActor(Actor actor, Long actorId) {
        return repository.findById(actorId).map( record -> {
            record.setName(actor.getName());
            record.setGender(actor.getGender());
            record.setNation(actor.getNation());
            record.setDateBorn(actor.getDateBorn());
            Actor updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<?> deleteActorById(Long actorId) {
        return repository.findById(actorId).map( record -> {
            repository.deleteById(actorId);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
