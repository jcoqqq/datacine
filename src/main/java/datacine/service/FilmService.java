package datacine.service;

import datacine.domain.Film;
import datacine.dto.FilmDto;
import datacine.mapping.FilmMapper;
import datacine.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class FilmService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final FilmRepository filmRepository;

    public FilmDto getFilms(Integer id) {
        try {
            Iterable<Film> films = filmRepository.findAll();

            for (Film a : films) {
                if (a.getId() == id)
                    return remplirFilm(a);
                else
                    return new FilmDto();
            }

        }
        catch (Exception e) {
            return new FilmDto();
        }
        return new FilmDto();
    }


    public FilmDto remplirFilm (Film film) {
        FilmDto filmDto = FilmMapper.filmToDto(film);

        String queryFilm = "SELECT film.id_film " +
                "as id_film " +
                "FROM acteur_film_realisateur,film,realisateur " +
                "WHERE acteur_film_realisateur.id_film=film.id_film " +
                "AND acteur_film_realisateur.id_realisateur=realisateur.id_realisateur " +
                "and realisateur.id_realisateur=" + film.getId();

        String sqlQueryAvis = "SELECT avisfilm.id_film as id_film " +
                "FROM avisfilm,film,user " +
                "WHERE film.id_film=avisfilm.id_film and user.id=avisfilm.id_user " +
                "and avisfilm.id_film=" + film.getId();

        String sqlQueryActeur = "SELECT acteur.id_acteur,acteur.nom,acteur.prenom " +
                "from acteur,acteur_film_realisateur,film " +
                "WHERE film.id_film=acteur_film_realisateur.id_film " +
                "AND acteur.id_acteur=acteur_film_realisateur.id_acteur " +
                "and acteur_film_realisateur.id_film=" + film.getId();

        List<Map<String, Object>> rowsRealisateur = jdbcTemplate.queryForList(queryFilm);
        List<Map<String, Object>> rowsAvis = jdbcTemplate.queryForList(sqlQueryAvis);
        List<Map<String, Object>> rowActeurs = jdbcTemplate.queryForList(sqlQueryActeur);

        filmDto.setIdAvis(rowsAvis);
        filmDto.setIdRealisateurs(rowsRealisateur);
        filmDto.setIdRealisateurs(rowActeurs);

        return filmDto;

    }
}
