package datacine.rest;

import datacine.dto.ActeurDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/acteur")
@EnableWebMvc
public interface IActeurRest {

    @GetMapping(value = "get/{id}")
    ActeurDto getActeur(@PathVariable Integer id);

}
