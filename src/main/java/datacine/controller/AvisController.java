package datacine.controller;

import datacine.rest.IAvisRest;
import datacine.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class AvisController implements IAvisRest {

    @Autowired
    private DataBaseService dataBaseService;

    @Override
    public Boolean getAvis() {
        return dataBaseService.getAvis();
    }

    @Override
    public Boolean addAvis() {
        return dataBaseService.addAvis();
    }
}
