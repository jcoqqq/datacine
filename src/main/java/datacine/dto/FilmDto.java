package datacine.dto;

import datacine.domain.Acteur;
import datacine.domain.Realisateur;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class FilmDto {

    private String nom;

    private List<RealisateurDto> realisateurs;

    private List<ActeurDto> acteurs;

    private List<AvisDto> avis;

    public List<AvisDto> getAvis() {
        return avis;
    }

    public void setAvis(List<AvisDto> avis) {
        this.avis = avis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<RealisateurDto> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<RealisateurDto> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<ActeurDto> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<ActeurDto> acteurs) {
        this.acteurs = acteurs;
    }
}
