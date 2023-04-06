package datacine.dto;

import javax.persistence.Column;

public class AvisDto {

    private String texte;

    private float note;

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
