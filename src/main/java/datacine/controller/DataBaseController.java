package datacine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import datacine.rest.DataBaseRest;
import datacine.service.DataBaseService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class DataBaseController implements DataBaseRest {

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
    public Boolean getReal() {
        return dataBaseService.getReal();
    }

    @Override
    public Boolean getFilm() {
        return dataBaseService.getFilm();
    }

    @Override
    public Boolean getAvis() {
        return dataBaseService.getAvis();
    }
}
