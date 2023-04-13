package datacine.service;

import datacine.domain.AvisFilm;
import datacine.dto.AvisDto;
import datacine.mapping.AvisMapper;
import datacine.repository.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AvisService {

    final AvisRepository avisRepository;

    public AvisDto getAvis(Integer id) {

        try {
            Iterable<AvisFilm> avis = avisRepository.findAll();

            for (AvisFilm a : avis) {

                if (a.getId_film_avis() == id)
                    return AvisMapper.avisToDto(a);
                else
                    return new AvisDto();
            }

        }
        catch (Exception e) {
            return new AvisDto();
        }
        return new AvisDto();
    }

    public AvisDto postAvis(Float note, String des, String user) {

        AvisFilm avisFilm = new AvisFilm();
        avisFilm.setNote(note);
        avisFilm.setAvis(user + des);
        avisFilm.setId_film_avis(10);

        return AvisMapper.avisToDto(avisRepository.save(avisFilm));

    }

    public Boolean deleteAvis(Integer id) {
        try {
            avisRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
