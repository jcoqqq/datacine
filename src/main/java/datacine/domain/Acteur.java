package datacine.domain;

import lombok.*;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "acteurs")
    @JoinColumn(name = "id_film")
    private List<Film> filmsTournes;

}
