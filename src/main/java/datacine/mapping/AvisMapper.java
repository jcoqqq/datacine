package datacine.mapping;

import datacine.domain.Avis;
import datacine.dto.AvisDto;

public class AvisMapper {

    public static AvisDto avisToDto(Avis avis) {
        AvisDto avisDto = new AvisDto();

        avisDto.setNote(avis.getNote());
        avisDto.setTexte(avis.getTexte());

        return avisDto;
    }
}
