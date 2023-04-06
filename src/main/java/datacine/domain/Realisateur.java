package datacine.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@org.springframework.data.annotation.Id
    @Column(name = "id_realisateur")
    private int id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @OneToMany
    @JoinColumn(name = "id_film")
    private List<Film> filmsRealises;

    @OneToMany
    @JoinColumn(name = "id_avis")
    private List<Avis> avis;
}
