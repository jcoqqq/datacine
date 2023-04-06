package datacine.mapping;


import datacine.domain.Film;
import datacine.dto.FilmDto;


public interface FilmMapper {

    FilmDto FilmToFilmDto(Film film);
}
