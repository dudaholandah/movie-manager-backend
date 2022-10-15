package br.moviemanager.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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
    @JsonManagedReference
    private Movie movie;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "fk_act_id")
    @JsonManagedReference
    private Actor actor;

    @Column(name = "act_character", length = 50)
    private String character;
}
