package datacine.mapping;

import datacine.domain.Realisateur;
import datacine.dto.RealisateurDto;


public interface RealisateurMapper {

    RealisateurDto realisateurToDto(Realisateur realisateur);
}
