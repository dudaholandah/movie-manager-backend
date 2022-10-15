package br.moviemanager.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieCastKey implements Serializable {

    @Column(name = "fk_act_id")
    private Long actorId;

    @Column(name = "fk_mov_id")
    private Long movieId;

}
