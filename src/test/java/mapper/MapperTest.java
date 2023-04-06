package mapper;

import datacine.domain.Acteur;
import datacine.domain.Film;
import datacine.dto.ActeurDto;
import datacine.mapping.ActeurMapper;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class MapperTest {


    private Acteur getActeur() {
        Film film = new Film();
        film.setNom("7");

        Acteur acteur = new Acteur();
        acteur.setId_acteur(2);
        acteur.setNom("Duj");
        acteur.setPrenom("Jan");
        acteur.setFilmsTournes(Collections.singletonList(film));

        return acteur;
    }

    @Test
    void ActeurToDtoTest() {
        Acteur acteur = getActeur();

        ActeurDto acteurDto = ActeurMapper.acteurToDto(acteur);
        assertThat(acteurDto).isNotNull();
        assertThat(acteurDto.getNom()).isEqualTo(acteur.getNom());
    }

}
