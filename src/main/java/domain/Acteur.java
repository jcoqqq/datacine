package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue
    @Column(name = "id_acteur")
    private UUID id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "id_films_tournes")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_films_tournes")
    @ToString.Exclude
    private List<Film> filmsTournes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acteur acteur = (Acteur) o;
        return Objects.equals(id, acteur.id) && Objects.equals(prenom, acteur.prenom) && Objects.equals(nom, acteur.nom) && Objects.equals(dateNaissance, acteur.dateNaissance) && Objects.equals(filmsTournes, acteur.filmsTournes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, dateNaissance, filmsTournes);
    }
}
