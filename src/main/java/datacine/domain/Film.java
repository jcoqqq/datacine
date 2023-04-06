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
    private int id;

    @Column(name = "nom")
    private String nom;

    @OneToMany
    @JoinColumn(name = "id_realisateur")
    private List<Realisateur> realisateurs;

    @OneToMany
    @JoinColumn(name = "id_acteur")
    private List<Acteur> acteurs;

    @OneToMany
    @JoinColumn(name = "id_avis")
    private List<Avis> avis;
}
