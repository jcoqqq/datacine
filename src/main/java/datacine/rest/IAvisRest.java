package datacine.rest;

import datacine.dto.AvisDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/avis")
@EnableWebMvc
public interface IAvisRest {

    @GetMapping(value = "get/{id}")
    AvisDto getAvis(@PathVariable Integer id);

    @PostMapping(value = "post/{note}/{des}/{user}")
    AvisDto postAvis(@PathVariable String note,
                         @PathVariable Float des,
                         @PathVariable String user);

    @DeleteMapping(value = "delete/avis")
    Boolean delete(Integer id);
}
