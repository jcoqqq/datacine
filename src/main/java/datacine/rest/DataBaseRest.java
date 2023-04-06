package datacine.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/v1")
@EnableWebMvc
public interface DataBaseRest {

    @PostMapping(value = "add/acteur")
    Boolean addActeur();

    @PostMapping(value = "add/avis")
    Boolean addAvis();

    @PostMapping(value = "add/realisateur")
    Boolean addRealisateur();

    @PostMapping(value = "add/film")
    Boolean addFilm();

    @GetMapping(value = "get/acteur")
    Boolean getActeur();

    @GetMapping(value = "get/real")
    Boolean getReal();

    @GetMapping(value = "get/film")
    Boolean getFilm();

    @GetMapping(value = "get/avis")
    Boolean getAvis();

    @DeleteMapping(value = "delete/avis/{id}")
    Boolean deleteAvis(@PathVariable int id);

    @DeleteMapping(value = "delete/acteur/{id}")
    Boolean deleteActeur(@PathVariable int id);

    @DeleteMapping(value = "delete/film/{id}")
    Boolean deleteFilm(@PathVariable int id);

    @DeleteMapping(value = "delete/realisateur/{id}")
    Boolean deleteRealisateur(@PathVariable int id);
}
