package datacine.domain;

import lombok.*;

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

    @OneToMany
    @Column(name = "id_realisateurs")
    @JoinColumn(name = "id_realisateur")
    @ToString.Exclude
    private List<Realisateur> realisateurs;

    @OneToMany
    @Column(name = "id_acteurs")
    @JoinColumn(name = "id_acteur")
    @ToString.Exclude
    private List<Acteur> acteurs;


}
