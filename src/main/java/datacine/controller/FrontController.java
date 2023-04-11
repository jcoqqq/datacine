package datacine.controller;

import datacine.service.DataFrontAcceuil;
import datacine.service.DataFrontFilmRea;
import datacine.service.RedirectPage;
import jakarta.activation.FileTypeMap;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@EnableWebMvc
@RequestMapping(value = "/")
public class FrontController {

    private final RedirectPage redirect = new RedirectPage();

    @GetMapping("/")
    public ModelAndView index(@PathVariable(required = false,name="page") String page, Model model) {

        DataFrontAcceuil data = new DataFrontAcceuil();
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
        String verifpage = redirect.Page(page);
        modelAndView.setViewName(verifpage);
        return modelAndView;
    }

    @RequestMapping(value = "/search/{search}")
    public ModelAndView search(@PathVariable(required = false,name="search") String search, Model model) {

        DataFrontAcceuil data = new DataFrontAcceuil();
        data.search(search);
        System.out.println(data.gethtml());
        model.addAttribute("data", data);
        // model.addAttribute("data", new Datafront()); // Ajouter un objet Data à votre modèle et vue

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/css/{fichier}")
    public String css(@PathVariable(required = false,name="fichier") String fichier)  {
        return redirect.chemincss(fichier);
    }

    @RequestMapping("/film/{id}")
    public ModelAndView film(@PathVariable(required = false,name="id") String id, Model model) {
        DataFrontFilmRea dataFrontFilmRea = new DataFrontFilmRea();
        dataFrontFilmRea.setid(id);
        dataFrontFilmRea.setfilm(true);
        model.addAttribute("data",dataFrontFilmRea); // Ajouter un objet Data à votre modèle et vue
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filmrea");
        return modelAndView;
    }

    @RequestMapping(value = "/js/{fichier}")
    public String js(@PathVariable(required = false,name="fichier") String fichier)  {
        return redirect.cheminjs(fichier);
    }

    @RequestMapping(value = "/image/film/{id}")
    public ResponseEntity<byte[]> getimage(@PathVariable(name="id") String id) throws IOException{
        String fichier = redirect.getnameimagefile(id);
        File img = new File("src/main/resources/templates/images/films/"+fichier);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }

    @RequestMapping(value = "/image/realisateur/{id}")
    public ResponseEntity<byte[]> getrealisateur(@PathVariable(name="id") String id) throws IOException{
        String fichier = redirect.getnameimageacteur(id);
        File img = new File("src/main/resources/templates/images/realisateurs/"+fichier);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }

    @RequestMapping(value = "/image/acteur/{id}")
    public ResponseEntity<byte[]> getacteur(@PathVariable(name="id") String id) throws IOException{
        String fichier = redirect.getnameimagerealisteaur(id);
        File img = new File("src/main/resources/templates/images/acteurs/"+fichier);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }
}
