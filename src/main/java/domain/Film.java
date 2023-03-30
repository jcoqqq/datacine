package domain;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue
    @Column(name = "id_film")
    private UUID id;

    @Column(name = "realisateur")
    private Realisateur realisateur;

    @Column(name = "id_acteurs")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_acteurs")
    @ToString.Exclude
    private List<Acteur> idActeurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Film film = (Film) o;
        return getId() != null && Objects.equals(getId(), film.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
