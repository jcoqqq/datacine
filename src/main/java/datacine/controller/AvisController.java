package datacine.controller;

import datacine.dto.AvisDto;
import datacine.rest.IAvisRest;
import datacine.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class AvisController implements IAvisRest {

    @Autowired
    private AvisService avisService;

    @Override
    public AvisDto getAvis(Integer id) {
        return avisService.getAvis(id);
    }

    @Override
    public AvisDto postAvis(Float note, String des, String user) {
        return avisService.postAvis(note, des, user);
    }

    @Override
    public Boolean delete(Integer id) {
        return avisService.deleteAvis(id);
    }
}
