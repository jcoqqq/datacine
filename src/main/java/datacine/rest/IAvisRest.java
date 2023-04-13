package datacine.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/avis")
@EnableWebMvc
public interface IAvisRest {

    @GetMapping(value = "get/avis")
    Boolean getAvis();

    @PostMapping(value = "add/avis")
    Boolean addAvis();
}
