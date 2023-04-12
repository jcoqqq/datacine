package datacine.service;

import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

public class Sesssionutilisateur {
    public HttpSession session;
    public void generatesssion(Boolean administrateur,String nom_utilistateur){
        session.setAttribute("administrateur",administrateur);
        session.setAttribute("nom",nom_utilistateur);

    }
    public boolean connected(){
        String name = (String) session.getAttribute("nom");
        if(name != null){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean admin(){
        Boolean admin = (Boolean) session.getAttribute("administrateur");
        return  admin;
        }
    }

