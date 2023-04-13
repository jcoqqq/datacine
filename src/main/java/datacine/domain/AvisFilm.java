package datacine.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AVIS_FILM")
public class AvisFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FILM_AVIS")
    private int id_film_avis;

    @Column(name = "AVIS")
    private String avis;

    @Column(name = "NOTE")
    private float note;
}
