package br.moviemanager.backend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalTime time;

    @Column(name = "mov_language", length = 50)
    private String language;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "moviegenres",
            joinColumns = @JoinColumn(name = "fk_mov_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_gen_id"))
    private Set<Genre> genres = new HashSet<>();

    public void addGenre(Genre genre){
        this.genres.add(genre);
        genre.getMovies().add(this);
    }

    public void removeGenre(Long genreId) {
        Genre genre = this.genres.stream().filter(t -> t.getId() == genreId).findFirst().orElse(null);
        if (genre != null) {
            this.genres.remove(genre);
            genre.getMovies().remove(this);
        }
    }

    public void removeGenres() {
        for (Genre genre : new HashSet<>(genres)) {
            removeGenre(genre.getId());
        }
    }

}
