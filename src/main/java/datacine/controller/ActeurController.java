package datacine.controller;

import datacine.dto.ActeurDto;
import datacine.rest.IActeurRest;
import datacine.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class ActeurController implements IActeurRest {

    @Autowired
    private ActeurService acteurService;


    @Override
    public ActeurDto getActeur(Integer id) {
        return acteurService.getActeurs(id);
    }

}
