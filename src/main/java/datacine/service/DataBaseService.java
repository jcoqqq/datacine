package datacine.service;

import datacine.domain.Acteur;
import datacine.domain.Avis;
import datacine.domain.Film;
import datacine.domain.Realisateur;
import datacine.repository.AvisRepository;
import datacine.repository.FilmRepository;
import datacine.repository.RealisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import datacine.repository.ActeurRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DataBaseService {

    final ActeurRepository acteurRepository;

    final RealisateurRepository realisateurRepository;

    final FilmRepository filmRepository;

    final AvisRepository avisRepository;

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
            //Iterable<Acteur> acteurs = acteurRepository.findAll();
            Optional<Acteur> acteur = acteurRepository.findByNom("jeeaaan");
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

    public Boolean getAvis() {
        try {
            Iterable<Avis> avis = avisRepository.findAll();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean addFilm() {
        Film film = new Film();

        try {
            filmRepository.save(film);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean addRealisateur() {
        Realisateur realisateur = new Realisateur();
        try {
            realisateurRepository.save(realisateur);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean addAvis() {
        Avis avis = new Avis();
        try {
            avisRepository.save(avis);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    //public Boolean deleteAvis(int id) {
      //  return avisRepository.deleteById(id);
    //}

    public Boolean deleteActeur(String nom) {
        return acteurRepository.deleteByNom(nom);
    }

    public Boolean deleteFilm(String nom) {
        return filmRepository.deleteByNom(nom);
    }

    public Boolean deleteRealisateur(String nom) {
        return realisateurRepository.deleteByNom(nom);
    }
}
