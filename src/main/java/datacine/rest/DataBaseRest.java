package datacine.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping(value = "/v1")
@EnableWebMvc
public interface DataBaseRest {

    @PostMapping(value = "/add/acteur")
    Boolean addActeur();

    @GetMapping(value = "/get/acteur")
    Boolean getActeur();


}
