package datacine.mapping;

import datacine.domain.Acteur;
import datacine.dto.ActeurDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {FilmMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActeurMapper {

    ActeurDto acteurToDto(Acteur acteur);
}
