package datacine.dto;

import datacine.domain.Film;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class RealisateurDto {

    private String prenom;

    private String nom;

    private LocalDate dateNaissance;

    private List<FilmDto> filmsRealises;

    private List<FilmDto> filmsTournes;
}
