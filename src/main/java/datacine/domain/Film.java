package datacine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "realisateurFilm",
            joinColumns = @JoinColumn( name = "id_film" ),
            inverseJoinColumns = @JoinColumn( name = "id_realisateur" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Realisateur> realisateurs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "acteurFilm",
            joinColumns = @JoinColumn( name = "id_film" ),
            inverseJoinColumns = @JoinColumn( name = "id_acteur" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Acteur> acteurs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filmAvis",
            joinColumns = @JoinColumn( name = "id_film" ),
            inverseJoinColumns = @JoinColumn( name = "id_avis" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Avis> avis;
}
