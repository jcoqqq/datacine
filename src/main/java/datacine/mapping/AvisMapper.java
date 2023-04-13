package datacine.mapping;

import datacine.domain.AvisFilm;
import datacine.dto.AvisDto;

public class AvisMapper {

    public static AvisDto avisToDto(AvisFilm avisFilm) {
        AvisDto avisDto = new AvisDto();

        avisDto.setNote(avisFilm.getNote());
        avisDto.setTexte(avisFilm.getAvis());

        return avisDto;
    }
}
