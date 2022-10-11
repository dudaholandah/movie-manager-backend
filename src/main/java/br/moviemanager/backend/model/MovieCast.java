package br.moviemanager.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "moviecast")
public class MovieCast {

    @EmbeddedId
    private MovieCastKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "fk_mov_id")
    private Movie movie;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "fk_act_id")
    private Actor actor;

    @Column(name = "act_character", length = 50)
    private String character;
}
