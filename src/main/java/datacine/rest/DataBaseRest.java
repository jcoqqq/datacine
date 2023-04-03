package datacine.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/v1")
public interface DataBaseRest {

    @PostMapping(value = "add/acteur")
    Boolean addActeur();

    @GetMapping(value = "get/acteur")
    Boolean getActeur();

}
