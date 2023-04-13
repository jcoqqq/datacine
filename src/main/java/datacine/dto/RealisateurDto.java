package datacine.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class RealisateurDto {

    private String prenom;

    private String nom;

    private LocalDate dateNaissance;

    private List<Map<String, Object>> idFilmsRealises;


}
