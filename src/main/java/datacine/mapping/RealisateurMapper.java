package datacine.mapping;

import datacine.domain.Avis;
import datacine.domain.Film;
import datacine.domain.Realisateur;
import datacine.dto.AvisDto;
import datacine.dto.FilmDto;
import datacine.dto.RealisateurDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

public class RealisateurMapper {

    public static RealisateurDto realisateurToDto(Realisateur realisateur) {
        RealisateurDto realisateurDto = new RealisateurDto();

        realisateurDto.setNom(realisateur.getNom());
        realisateurDto.setPrenom(realisateur.getPrenom());
        realisateurDto.setDateNaissance(realisateur.getDateNaissance());

        List<FilmDto> filmsRealises = new ArrayList<>();

        for (Film film : realisateur.getFilmsRealises()) {
            filmsRealises.add(FilmMapper.filmToDto(film));
        }

        List<AvisDto> avisDtos = new ArrayList<>();

        if (realisateur.getAvis() != null)
            for (Avis avis : realisateur.getAvis()) {
                avisDtos.add(AvisMapper.avisToDto(avis));
            }

        realisateurDto.setFilmsRealises(filmsRealises);
        realisateurDto.setAvis(avisDtos);

        return realisateurDto;
    }
}
