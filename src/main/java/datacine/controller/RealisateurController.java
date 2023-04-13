package datacine.controller;

import datacine.rest.IRealisateurRest;
import datacine.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class RealisateurController implements IRealisateurRest {

    @Autowired
    private DataBaseService dataBaseService;

    @Override
    public Boolean getReal() {
        return dataBaseService.getReal();
    }

    @Override
    public Boolean addRealisateur() {
        return dataBaseService.addRealisateur();
    }


    @Override
    public Boolean deleteRealisateur(String nom) {
        return dataBaseService.deleteRealisateur(nom);
    }
}
