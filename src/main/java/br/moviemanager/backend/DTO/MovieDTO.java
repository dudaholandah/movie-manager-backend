package br.moviemanager.backend.DTO;

import lombok.*;

import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieDTO {
    private Long id;
    private String title;
    private Integer year;
    private LocalTime time;
    private String language;
    private Set<String> genres;
}
