package datacine.dto;

import datacine.domain.Film;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
public class ActeurDto {

    private String prenom;

    private String nom;

    private LocalDate dateNaissance;

    private List<FilmDto> filmsTournes;
}
