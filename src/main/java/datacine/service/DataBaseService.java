package datacine.service;

import datacine.domain.Acteur;
import datacine.domain.Film;
import datacine.domain.Realisateur;
import datacine.repository.FilmRepository;
import datacine.repository.RealisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import datacine.repository.ActeurRepository;

@Service
@AllArgsConstructor
public class DataBaseService {

    final ActeurRepository acteurRepository;

    final RealisateurRepository realisateurRepository;

    final FilmRepository filmRepository;

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

    public Boolean getReal() {
        try {
            Iterable<Realisateur> realisateurs = realisateurRepository.findAll();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean getFilm() {
        try {
            Iterable<Film> films = filmRepository.findAll();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
