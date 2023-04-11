package datacine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM")
    private String nom;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "realisateurFilm",
            joinColumns = @JoinColumn( name = "id_film" ),
            inverseJoinColumns = @JoinColumn( name = "id_realisateur" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Realisateur> realisateurs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "acteurFilm",
            joinColumns = @JoinColumn( name = "id_film" ),
            inverseJoinColumns = @JoinColumn( name = "id_acteur" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Acteur> acteurs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filmAvis",
            joinColumns = @JoinColumn( name = "id_film" ),
            inverseJoinColumns = @JoinColumn( name = "id_avis" ))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Avis> avis;
}
