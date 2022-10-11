package br.moviemanager.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Long id;

    @Column(name = "act_name", length = 50)
    @NotEmpty(message = "Field name is required.")
    private String name;

    @Column(name = "act_nation", length = 50)
    private String nation;

    @Column(name = "act_date_born")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBorn;

    @Column(name = "act_gender", length = 50)
    private String gender;

//    @OneToMany(mappedBy = "actor")
//    private Set<MovieCast> characters;

}
