package datacine.mapping;

import org.mapstruct.Mapper;

import datacine.domain.Film;
import datacine.dto.FilmDto;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {RealisateurMapper.class, ActeurMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FilmMapper {

    FilmDto FilmToFilmDto(Film film);
}
