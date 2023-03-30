package service;

import domain.Acteur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.ActeurRepository;
import rest.DataBaseRest;

@Service
@Slf4j
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
}
