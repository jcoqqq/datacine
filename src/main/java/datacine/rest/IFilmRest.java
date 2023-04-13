package datacine.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/film")
@EnableWebMvc
public interface IFilmRest {

    @GetMapping(value = "get/film")
    Boolean getFilm();

    @PostMapping(value = "add/film")
    Boolean addFilm();

    @DeleteMapping(value = "delete/film/{nom}")
    Boolean deleteFilm(@PathVariable String nom);
}
