package datacine.rest;

import datacine.dto.RealisateurDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/realisateur")
@EnableWebMvc
public interface IRealisateurRest {

    @GetMapping(value = "get/{id}")
    RealisateurDto getReal(Integer id);

}
