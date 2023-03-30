package domain;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.util.List;

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
    private int id;

    @OneToOne
    @JoinColumn(name = "id_realisateur")
    private Realisateur realisateur;

    @OneToMany
    @Column(name = "id_acteurs")
    @JoinColumn(name = "id_acteur")
    @ToString.Exclude
    private List<Acteur> idActeurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
