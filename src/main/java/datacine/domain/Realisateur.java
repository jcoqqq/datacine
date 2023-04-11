package datacine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "REALISATEUR")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DATE_NAISSANCE")
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
