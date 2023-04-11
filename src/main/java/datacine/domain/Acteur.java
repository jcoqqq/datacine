package datacine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acteur")
    private int id_acteur;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "acteurFilm",
            joinColumns = @JoinColumn( name = "id_acteur" ),
            inverseJoinColumns = @JoinColumn( name = "id_film" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Film> filmsTournes;

}
