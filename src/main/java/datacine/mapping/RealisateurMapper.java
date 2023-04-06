package datacine.mapping;

import datacine.domain.Realisateur;
import datacine.dto.RealisateurDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {FilmMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RealisateurMapper {

    RealisateurDto realisateurToDto(Realisateur realisateur);
}
