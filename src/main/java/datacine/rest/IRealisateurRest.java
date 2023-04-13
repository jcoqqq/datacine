package datacine.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/realisateur")
@EnableWebMvc
public interface IRealisateurRest {

    @DeleteMapping(value = "delete/realisateur/{nom}")
    Boolean deleteRealisateur(@PathVariable String nom);

    @GetMapping(value = "get/real")
    Boolean getReal();

    @PostMapping(value = "add/realisateur")
    Boolean addRealisateur();
}
