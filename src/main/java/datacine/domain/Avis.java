package datacine.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "avis")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avis")
    private int id_avis;

    @Column(name = "texte")
    private String texte;

    @Column(name = "note")
    private float note;
}
