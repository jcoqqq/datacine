package datacine.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class FilmDto {

    private String nom;

    private List<Map<String, Object>> idRealisateurs;

    private List<Map<String, Object>> idActeurs;

    private List<Map<String, Object>> idAvis;


}
