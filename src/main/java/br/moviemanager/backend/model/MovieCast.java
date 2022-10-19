package br.moviemanager.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "moviecast")
public class MovieCast {

    @EmbeddedId
    private MovieCastKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "fk_mov_id")
    //@JsonManagedReference
    private Movie movie;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "fk_act_id")
    //@JsonManagedReference
    private Actor actor;

    @Column(name = "act_character", length = 50)
    private String character;
}
