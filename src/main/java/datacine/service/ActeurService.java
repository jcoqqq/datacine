package datacine.service;

import datacine.domain.Acteur;
import datacine.dto.ActeurDto;
import datacine.mapping.ActeurMapper;
import datacine.repository.ActeurRepository;
import datacine.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ActeurService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final ActeurRepository acteurRepository;

    final FilmRepository filmRepository;


    public ActeurDto getActeurs(Integer id) {
        try {
            Iterable<Acteur> acteurs = acteurRepository.findAll();

            for (Acteur a : acteurs) {
                if (a.getId_acteur() == id)
                    return remplirActeur(a);
                else
                    return new ActeurDto();
            }

        }
        catch (Exception e) {
            return new ActeurDto();
        }
        return new ActeurDto();
    }

    public ActeurDto remplirActeur(Acteur acteur) {
        ActeurDto acteurDto = ActeurMapper.acteurToDto(acteur);

        String sqlQuery = "SELECT film.id_film " +
                "as id_film, film.nom " +
                "FROM acteur_film_realisateur,acteur,film " +
                "WHERE acteur_film_realisateur.id_acteur=acteur.id_acteur " +
                "AND acteur_film_realisateur.id_film=film.id_film " +
                "and acteur.id_acteur=" + acteur.getId_acteur()+";";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlQuery);
        acteurDto.setIdFilmsTournes(rows);

        return acteurDto;

    }
}
