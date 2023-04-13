package datacine.controller;

import datacine.service.InterFaceUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class utilisateurConstroller {
    @Autowired
    JdbcTemplate jdbcTemplates;
    @GetMapping (value = "/backutilisateur/connexion")
    public String connexion(HttpServletRequest request){
        String user=request.getParameter("user");
        String password=request.getParameter("password");
        InterFaceUser interFaceUser = new InterFaceUser();
        String reponse= interFaceUser.setverifuser(user,password,jdbcTemplates);
        return  reponse;
    }
    @PostMapping  (value = "/backutilisateur/inscription")
    public String inscription(HttpServletRequest request){
        String user=request.getParameter("user");
        String mail=request.getParameter("mail");
        String password=request.getParameter("password");
        InterFaceUser interFaceUser = new InterFaceUser();
        String reponse= interFaceUser.setverifuser(user,mail,password,jdbcTemplates);
        return  reponse;
    }
}
