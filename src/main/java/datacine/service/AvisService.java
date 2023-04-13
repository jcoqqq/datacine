package datacine.service;

import datacine.domain.Avis;
import datacine.dto.AvisDto;
import datacine.mapping.AvisMapper;
import datacine.repository.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvisService {

    final AvisRepository avisRepository;

    public AvisDto getAvis(Integer id) {

        try {
            Iterable<Avis> avis = avisRepository.findAll();

            for (Avis a : avis) {

                if (a.getId() == id)
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

        Avis avis = new Avis();
        avis.setNote(note);
        avis.setTexte(user + des);

        return AvisMapper.avisToDto(avisRepository.save(avis));

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
