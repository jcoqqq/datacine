package datacine.controller;

import datacine.service.DataFrontAcceuil;
import datacine.service.FormulaireProxy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.reactive.result.view.RedirectView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@RestController
@EnableWebMvc
public class ProxyFrontBack {
    @RequestMapping(value = "/proxy/searchjs/{search}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getFilms(@PathVariable(required = false,name="search") String search ) {
        DataFrontAcceuil front = new DataFrontAcceuil();
        String jsonData=front.setjson(search);
        return jsonData;
    }
    @PostMapping("/proxy/inscription")
    public ModelAndView  postinscription(HttpServletRequest request) {
        FormulaireProxy formulaireProxy = new FormulaireProxy();
        String username=request.getParameter("utilisateur");
        String mail = request.getParameter("mail");
        String password=request.getParameter("password");
        String information=formulaireProxy.setinscription(username, mail, password);
        HttpSession session = request.getSession();
        session.setAttribute("information",information);
        ModelAndView mav;
        System.out.println(information);
        if(formulaireProxy.getFormulairevalide()){
             mav = new ModelAndView("redirect:/connexion");
        }
        else{
             mav = new ModelAndView("redirect:/inscription");

        }
        return mav;
    }
    @PostMapping("/proxy/connexion")
    public ModelAndView  postconnexion(HttpServletRequest request) {
        FormulaireProxy formulaireProxy = new FormulaireProxy();
        String utilisateur=request.getParameter("utilisateur");
        String password=request.getParameter("password");
        Boolean verification=formulaireProxy.setconnexion(utilisateur, password);
        HttpSession session = request.getSession();
        ModelAndView mav;

        if(verification==true){
            session.setAttribute("utilisateur",utilisateur);
            session.setAttribute("administrateur",formulaireProxy.admin());
            if(session.getAttribute("page")!=null) {
                mav = new ModelAndView("redirect:"+session.getAttribute("page"));

            }
            else{
                mav = new ModelAndView("redirect:/");

            }

        }
        else {
            session.setAttribute("information", "l'utilisateur ou le mot de passe est incorrect");
            mav = new ModelAndView("redirect:/connexion");

        }

        return mav;
    }
    @GetMapping(value = "/proxy/commentaire/delete")
    public ModelAndView deleteproxyfilm(HttpServletRequest request ) {
        String id_film=request.getParameter("id_film");
        String id_commentaire=request.getParameter("id_commentaire");
        String type=request.getParameter("type");
        FormulaireProxy formulaireProxy = new FormulaireProxy();
        formulaireProxy.setidcommentaire(id_film,id_commentaire,type);
        String information=formulaireProxy.deletefilm();
        HttpSession session = request.getSession();
        session.setAttribute("information",information);
        ModelAndView mav = new ModelAndView("redirect:/film/"+id_film);
        return mav;



    }

}
