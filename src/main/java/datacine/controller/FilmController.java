package datacine.controller;

import datacine.rest.IFilmRest;
import datacine.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class FilmController implements IFilmRest {

    @Autowired
    private DataBaseService dataBaseService;

    @Override
    public Boolean addFilm() {
        return dataBaseService.addFilm();
    }

    @Override
    public Boolean deleteFilm(String nom) {
        return dataBaseService.deleteFilm(nom);
    }

    @Override
    public Boolean getFilm() {
        return dataBaseService.getFilm();
    }
}
