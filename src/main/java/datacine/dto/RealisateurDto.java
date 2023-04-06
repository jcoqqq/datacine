package datacine.dto;

import datacine.domain.Film;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RealisateurDto {

    private String prenom;

    private String nom;

    private LocalDate dateNaissance;

    private List<FilmDto> filmsRealises;

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

    public List<FilmDto> getFilmsRealises() {
        return filmsRealises;
    }

    public void setFilmsRealises(List<FilmDto> filmsRealises) {
        this.filmsRealises = filmsRealises;
    }
}
