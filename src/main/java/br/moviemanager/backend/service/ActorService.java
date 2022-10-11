package br.moviemanager.backend.service;

import br.moviemanager.backend.model.Actor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActorService {

    Actor saveActor(Actor actor);
    List<Actor> findAllActor();
    Actor findActorById(Long actorId);
    ResponseEntity<Actor> updateActor(Actor actor, Long actorId);
    ResponseEntity<?> deleteActorById(Long actorId);

}
