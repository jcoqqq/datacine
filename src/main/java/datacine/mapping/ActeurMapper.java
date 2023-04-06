package datacine.mapping;

import datacine.domain.Acteur;
import datacine.domain.Film;
import datacine.dto.ActeurDto;
import datacine.dto.FilmDto;

import java.util.ArrayList;
import java.util.List;

public class ActeurMapper {

    public static ActeurDto acteurToDto(Acteur acteur) {
        ActeurDto acteurDto = new ActeurDto();

        acteurDto.setNom(acteur.getNom());
        acteurDto.setPrenom(acteur.getPrenom());
        acteurDto.setDateNaissance(acteur.getDateNaissance());

        List<FilmDto> filmDtoList = new ArrayList<>();

        for (Film film : acteur.getFilmsTournes()) {
            filmDtoList.add(FilmMapper.filmToDto(film));
        }

        acteurDto.setFilmsTournes(filmDtoList);

        return acteurDto;
    }
}
