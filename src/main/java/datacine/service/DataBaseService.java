package datacine.service;

import datacine.domain.Acteur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import datacine.repository.ActeurRepository;

@Service
@AllArgsConstructor
public class DataBaseService {

    final ActeurRepository acteurRepository;

    public Boolean addActeur() {
        Acteur acteur = new Acteur();
        acteur.setPrenom("Jean");
        acteur.setNom("Dujardin");
        try {
            acteurRepository.save(acteur);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean getActeur() {
        try {
            Iterable<Acteur> acteurs = acteurRepository.findAll();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
