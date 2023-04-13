package datacine.controller;

import datacine.dto.AvisDto;
import datacine.rest.IAvisRest;
import datacine.service.AvisService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class AvisController implements IAvisRest {

    AvisService avisService;

    @Override
    public AvisDto getAvis(Integer id) {
        return avisService.getAvis(id);
    }

    @Override
    public AvisDto postAvis(String note, Float des, String user) {
        return avisService.postAvis(des, note, user);
    }

    @Override
    public Boolean delete(Integer id) {
        return avisService.deleteAvis(id);
    }
}
