package domain;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue
    @Column(name = "id_realisateur")
    private int id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @OneToMany
    @Column(name = "id_films_realises")
    @JoinColumn(name = "id_film")
    @ToString.Exclude
    private List<Film> filmsRealises;

    @OneToMany
    @Column(name = "id_films_tournes")
    @JoinColumn(name = "id_film")
    @ToString.Exclude
    private List<Film> filmsTournes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null) {
            ProxyUtils.getUserClass(this);
            ProxyUtils.getUserClass(o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
