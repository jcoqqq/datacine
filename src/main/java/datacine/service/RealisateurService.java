package datacine.service;

import datacine.domain.Film;
import datacine.domain.Realisateur;
import datacine.dto.FilmDto;
import datacine.dto.RealisateurDto;
import datacine.mapping.RealisateurMapper;
import datacine.repository.RealisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RealisateurService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final RealisateurRepository realisateurRepository;

    public RealisateurDto getRealisateurs(Integer id) {
        try {
            Iterable<Realisateur> realisateurs = realisateurRepository.findAll();

            for (Realisateur a : realisateurs) {
                if (a.getId() == id)
                    return remplirRealisateur(a);
                else
                    return new RealisateurDto();
            }

        }
        catch (Exception e) {
            return new RealisateurDto();
        }
        return new RealisateurDto();
    }


    public RealisateurDto remplirRealisateur(Realisateur realisateur) {

        RealisateurDto realisateurDto = RealisateurMapper.realisateurToDto(realisateur);

        String sqlQuery = "SELECT realisateur.id_realisateur, realisateur.prenom " +
                "as prenom,realisateur.nom " +
                "as nom " +
                "from realisateur,acteur_film_realisateur,film " +
                "WHERE film.id_film=acteur_film_realisateur.id_film " +
                "AND realisateur.id_realisateur=acteur_film_realisateur.id_realisateur " +
                "and acteur_film_realisateur.id_film=" + realisateur.getId();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlQuery);

        realisateurDto.setIdFilmsRealises(rows);

        return realisateurDto;
    }
}
