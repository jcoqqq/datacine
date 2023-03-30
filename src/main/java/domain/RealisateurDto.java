package domain;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class RealisateurDto {

    private UUID id;

    private String prenom;

    private String nom;

    private LocalDate dateNaissance;

    private List<Film> filmsRealises;

    private List<Film> filmsTournes;
}
