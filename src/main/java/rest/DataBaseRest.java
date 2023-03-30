package rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/v1")
public interface DataBaseRest {

    @PostMapping("add/acteur")
    Boolean addActeur();
}
