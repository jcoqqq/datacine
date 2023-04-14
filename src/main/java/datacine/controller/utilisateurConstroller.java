package datacine.controller;

import datacine.service.InterFaceUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@RestController
@EnableWebMvc
public class utilisateurConstroller {
    @Autowired
    JdbcTemplate jdbcTemplates;

    @GetMapping(value = "/backutilisateur/connexion")
    public String connexion(HttpServletRequest request) {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        InterFaceUser interFaceUser = new InterFaceUser();
        String reponse = interFaceUser.setverifuser(user, password, jdbcTemplates);
        return reponse;
    }

    @PostMapping(value = "/backutilisateur/inscription")
    public String inscription(HttpServletRequest request) {
        String user = request.getParameter("user");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        InterFaceUser interFaceUser = new InterFaceUser();
        String reponse = interFaceUser.setverifuser(user, mail, password, jdbcTemplates);
        return reponse;
    }

    @GetMapping(value = "/backutilisateur/film")
    public Map<String, Object> film(HttpServletRequest request) {

        InterFaceUser interFaceUser = new InterFaceUser();
        Map<String, Object> reponse = interFaceUser.getfilm(jdbcTemplates);
        return reponse;
    }

    @GetMapping(value = "/backutilisateur/searchfilm")
    public Map<String, Object> filmsearch(HttpServletRequest request) {

        InterFaceUser interFaceUser = new InterFaceUser();
        String nom = request.getParameter("nom");

        Map<String, Object> reponse = interFaceUser.getsearchfilm(jdbcTemplates, nom);
        return reponse;
    }

    @GetMapping(value = "/backutilisateur/description")
    public String descriptionfilm(HttpServletRequest request) {

        InterFaceUser interFaceUser = new InterFaceUser();
        String id = request.getParameter("id");

        String reponse = interFaceUser.getdescriptionfilm(jdbcTemplates, id);
        return reponse;
    }
    @GetMapping(value = "/backutilisateur/getcommentaire")
    public Map<String, Object> getcommentaire(HttpServletRequest request) {

        InterFaceUser interFaceUser = new InterFaceUser();
        String id = request.getParameter("id");

        Map<String, Object> reponse = interFaceUser.getlistcommentaire(jdbcTemplates, id);
        return reponse;
    }
    @DeleteMapping(value = "/backutilisateur/delcommentaire")
    public String  delcommentaire(HttpServletRequest request) {

        InterFaceUser interFaceUser = new InterFaceUser();
        String id = request.getParameter("id");

       String reponse = interFaceUser.dellistcommentaire(jdbcTemplates, id);
        return reponse;
    }
    @PostMapping(value = "/backutilisateur/insercommentaire")
    public String addcommentaire(HttpServletRequest request) {

        InterFaceUser interFaceUser = new InterFaceUser();
        String id = request.getParameter("id");
        String note = request.getParameter("note");
        String description = request.getParameter("description");

        String reponse = interFaceUser.insercommentaire(jdbcTemplates, id,note,description);
        return reponse;
    }
}