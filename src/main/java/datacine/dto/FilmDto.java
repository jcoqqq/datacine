package datacine.dto;

import datacine.domain.Acteur;
import datacine.domain.Realisateur;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class FilmDto {

    private String nom;

    private List<RealisateurDto> realisateurs;

    private List<ActeurDto> acteurs;
}
