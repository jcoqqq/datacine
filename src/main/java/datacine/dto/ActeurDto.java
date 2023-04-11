package datacine.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class ActeurDto {

    private String prenom;

    private String nom;

    private LocalDate dateNaissance;

    private List<FilmDto> filmsTournes;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<FilmDto> getFilmsTournes() {
        return filmsTournes;
    }

    public void setFilmsTournes(List<FilmDto> filmsTournes) {
        this.filmsTournes = filmsTournes;
    }
}
