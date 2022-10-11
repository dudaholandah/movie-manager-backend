package br.moviemanager.backend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mov_id")
    private Long id;

    @Column(name = "mov_title", length = 50)
    @NotEmpty(message = "Field title is required.")
    private String title;

    @Column(name = "mov_year")
    private Integer year;

    @Column(name = "mov_time")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time time;

    @Column(name = "mov_language", length = 50)
    private String language;

//    @OneToMany(mappedBy = "movie")
//    private Set<MovieCast> characters;

}
