package br.moviemanager.backend.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieCastDTO {
    private Long movieId;
    private Long actorId;
    private String character;
}
