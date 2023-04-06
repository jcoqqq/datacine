package datacine.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private int id_film;

    @Column(name = "nom")
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "realisateur",
            joinColumns = @JoinColumn(name = "id_realisateur"))
    private List<Realisateur> realisateurs;

    @ManyToMany
    @JoinTable(
            name = "acteur",
            joinColumns = @JoinColumn(name = "id_films_tournes"),
            inverseJoinColumns = @JoinColumn(name = "id_acteur"))
    private List<Acteur> acteurs;

    @ManyToMany
    @JoinTable(
            name = "avis",
            joinColumns = @JoinColumn(name = "id_avis"))
    private List<Avis> avis;
}
