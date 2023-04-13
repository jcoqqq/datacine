package datacine.mapping;

import datacine.domain.Acteur;
import datacine.domain.Film;
import datacine.dto.ActeurDto;
import datacine.dto.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ActeurMapper {

    public static ActeurDto acteurToDto(Acteur acteur) {
        ActeurDto acteurDto = new ActeurDto();

        acteurDto.setNom(acteur.getNom());
        acteurDto.setPrenom(acteur.getPrenom());
        acteurDto.setDateNaissance(acteur.getDateNaissance());

        return acteurDto;
    }
}
