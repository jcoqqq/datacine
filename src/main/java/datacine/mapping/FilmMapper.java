package datacine.mapping;

import datacine.domain.Film;
import datacine.dto.ActeurDto;
import datacine.dto.FilmDto;

import java.util.ArrayList;
import java.util.List;

public class FilmMapper {

    public static FilmDto filmToDto(Film film) {
        FilmDto filmDto = new FilmDto();

        filmDto.setNom(film.getNom());

        List<ActeurDto> acteurDtoList = new ArrayList<>();

        /*if (film.getActeurs() != null)
            for (Acteur acteur : film.getActeurs()) {
                acteurDtoList.add(ActeurMapper.acteurToDto(acteur));
            }

        List<RealisateurDto> realisateurDtoList = new ArrayList<>();

        if (film.getRealisateurs() != null)
            for (Realisateur realisateur : film.getRealisateurs()) {
                realisateurDtoList.add(RealisateurMapper.realisateurToDto(realisateur));
            }

        List<AvisDto> avisDtos = new ArrayList<>();

        if (film.getAvis() != null)
            for (Avis avis : film.getAvis()) {
                avisDtos.add(AvisMapper.avisToDto(avis));
            }

        filmDto.setRealisateurs(realisateurDtoList);
        filmDto.setActeurs(acteurDtoList);
        filmDto.setAvis(avisDtos);
*/
        return filmDto;
    }
}
