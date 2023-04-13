package datacine.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/acteur")
@EnableWebMvc
public interface IActeurRest {

    @PostMapping(value = "add/acteur")
    Boolean addActeur();

    @GetMapping(value = "get/acteur")
    Boolean getActeur();

    @DeleteMapping(value = "delete/acteur/{nom}")
    Boolean deleteActeur(@PathVariable String nom);
}
