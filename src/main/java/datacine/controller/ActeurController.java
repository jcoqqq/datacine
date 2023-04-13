package datacine.controller;

import datacine.rest.IActeurRest;
import datacine.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class ActeurController implements IActeurRest {

    @Autowired
    private DataBaseService dataBaseService;

    @Override
    public Boolean addActeur() {
        return dataBaseService.addActeur();
    }

    @Override
    public Boolean getActeur() {
        return dataBaseService.getActeur();
    }

    @Override
    public Boolean deleteActeur(String nom) {
        return dataBaseService.deleteActeur(nom);
    }
}
