package datacine.controller;

import datacine.service.DataFrontAcceuil;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@EnableWebMvc

public class proxy_front_back {
    @RequestMapping(value = "/proxy/searchjs/{search}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
    public String getFilms(@PathVariable(required = false,name="search") String search ) {
        DataFrontAcceuil front = new DataFrontAcceuil();
        String jsonData=front.setjson(search);
        return jsonData;
    }

}
