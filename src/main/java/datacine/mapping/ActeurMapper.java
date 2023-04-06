package datacine.mapping;

import datacine.domain.Acteur;
import datacine.dto.ActeurDto;


public interface ActeurMapper {

    ActeurDto acteurToDto(Acteur acteur);
}
