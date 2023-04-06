package datacine.controller;

import datacine.service.Datafront;
import datacine.service.RedirectPage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@RestController
@EnableWebMvc
@RequestMapping(value = "/")
public class FrontController {
    private RedirectPage redirect = new RedirectPage();
    @GetMapping("/")
    public ModelAndView index(@PathVariable(required = false,name="page") String page, Model model) {

        Datafront data = new Datafront();
       data.film();
        System.out.println(data.gethtml());
        model.addAttribute("data", data);
       // model.addAttribute("data", new Datafront()); // Ajouter un objet Data à votre modèle et vue

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/{page}")
    public ModelAndView hello(@PathVariable(required = false,name="page") String page) {
        ModelAndView modelAndView = new ModelAndView();
        String verifpage=redirect.Page(page);
        modelAndView.setViewName(verifpage);
        return modelAndView;
    }

    @RequestMapping(value = "/css/{fichier}")
    public String css(@PathVariable(required = false,name="fichier") String fichier)  {
            String contenu=redirect.chemincss(fichier);
            return contenu;
    }
    @RequestMapping(value = "/js/{fichier}")
    public String js(@PathVariable(required = false,name="fichier") String fichier)  {
        String contenu=redirect.cheminjs(fichier);
        return contenu;
    }
}
