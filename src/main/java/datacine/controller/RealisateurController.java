package datacine.controller;

import datacine.dto.RealisateurDto;
import datacine.rest.IRealisateurRest;
import datacine.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class RealisateurController implements IRealisateurRest {

    @Autowired
    private RealisateurService realisateurService;

    @Override
    public RealisateurDto getReal(Integer id) {
        return realisateurService.getRealisateurs(id);
    }

}
