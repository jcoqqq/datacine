package controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import rest.DataBaseRest;
import service.DataBaseService;

@RestController
@Slf4j
@AllArgsConstructor
public class DataBaseController implements DataBaseRest {

    private DataBaseService dataBaseService;

    @Override
    public Boolean addActeur() {
        return dataBaseService.addActeur();
    }
}
