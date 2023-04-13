package datacine.rest;

import datacine.dto.FilmDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/film")
@EnableWebMvc
public interface IFilmRest {

    @GetMapping(value = "get/{id}")
    FilmDto getFilm(Integer id);

}
