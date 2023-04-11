package datacine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_realisateur")
    private int id_realisateur;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "realisateurFilm",
            joinColumns = @JoinColumn( name = "id_realisateur" ),
            inverseJoinColumns = @JoinColumn( name = "id_film" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Film> filmsRealises;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "realisateurAvis",
            joinColumns = @JoinColumn( name = "id_realisateur" ),
            inverseJoinColumns = @JoinColumn( name = "id_avis" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Avis> avis;
}
