package domain;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

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
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue
    @Column(name = "id_realisateur")
    private UUID id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "id_films_tournes_realises")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_films_tournes_realises")
    @ToString.Exclude
    private List<Film> filmsRealises;

    @Column(name = "id_films_tournes")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_films_tournes")
    @ToString.Exclude
    private List<Film> filmsTournes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Realisateur that = (Realisateur) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
