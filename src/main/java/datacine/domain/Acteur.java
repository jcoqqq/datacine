package datacine.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACTEUR")
public class Acteur {

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

    @ManyToMany
    @JoinTable(name = "ACTEUR_FILM",
        joinColumns = @JoinColumn(name = "ID_ACTEUR"),
        inverseJoinColumns = @JoinColumn(name = "ID_FILM"))
    private List<Film> films;


}
