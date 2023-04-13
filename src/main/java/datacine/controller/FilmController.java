package datacine.controller;

import datacine.dto.FilmDto;
import datacine.rest.IFilmRest;
import datacine.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class FilmController implements IFilmRest {

    @Autowired
    private FilmService filmService;

    @Override
    public FilmDto getFilm(Integer id) {
        return filmService.getFilms(id);
    }
}
