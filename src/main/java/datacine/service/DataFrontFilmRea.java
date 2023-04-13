package datacine.service;

import jakarta.servlet.http.HttpSession;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class DataFrontFilmRea {
    private String id=null;
    Dictionary<String, String> monDictionnaire   = new Hashtable<String, String>();


    private HttpSession session;
    private String type;

    public void setid(String id) {
        this.id=id;
    }

    public void settype(String type) {
        this.type="film";
    }

    public String getdescription(){
        String chemin="/"+type+"/1";
        String number_commentaire="12";
        String number_avis="10";
        String description="hello";

        String text="<div class=\"images\">\n" +
                "    <img class=\"image-miniature\" src=\"/image"+chemin+"\" alt=\"Image 1\">\n" +
                "    <div>\n" +
                "        <p>"+number_commentaire+" commentaires</p>\n" +
                "        <p>"+number_avis+" avis</p>\n" +

                "        <p>"+description+"</p>\n" +
                "    </div>\n" +
                "</div>";
        return text;
    }
    public String getreafilm(){
        Dictionary<String, String> monDictionnaire2   = new Hashtable<String, String>();

        monDictionnaire2.put("/realisateur/0", "tres bon film ");
        monDictionnaire2.put("/acteur/8", "test 2");
        monDictionnaire2.put("/realisateur/5", "tres bon réalisateur");
        monDictionnaire2.put("/acteur/4", "tres bon film");

        String text="";
        Enumeration<String> e = monDictionnaire2.keys();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            String value = monDictionnaire2.get(key);
           text += "<div>" +
                   "<img class='image-miniature' src='/image" + key +" ' alt=Image 1 miniature>\n" +
                   "<p>"+value+"</p>\n" +
                   "</div>";
           }
           return text;
       }
       public String informationdeletecommentaire(){
            if( session.getAttribute("information")!=null) {
                String informationdeletecommentaire= (String) session.getAttribute("information");
                session.removeAttribute("information");
                return informationdeletecommentaire;
            }
            else{
                return null;
            }
       }
    public String getlistecommentaire(){
        String chemin="/proxy/commentaire/delete?id_film=2&type=film&id_commentaire=";
        monDictionnaire.put(chemin+"0","tres bon film ");
        monDictionnaire.put(chemin+"8", "test 2");
        monDictionnaire.put(chemin+"5", "tres bon réalisateur");
        monDictionnaire.put(chemin+"4", "tres bon film");
        monDictionnaire.put(chemin+"2", "tres bon test");
        monDictionnaire.put(chemin+"13", "hello");
        String text="";
        Enumeration<String> e = monDictionnaire.keys();
        boolean admin = false;
        if(session.getAttribute("administrateur")!=null){
            admin= (Boolean) session.getAttribute("administrateur");
        }
       //remplacer par un get pour vérifier que c'est un admin
        while (e.hasMoreElements()) {

            // Getting the key of a particular entry
            String key = e.nextElement();
            String value = monDictionnaire.get(key);
            text+="<div>" +
                    "<p>"+value+"</p>";
                    if(admin==true) {
                        text+=" <a href=" + key + ">Supprimer</a> ";
                    }
                    text+="</div>";

        }
        return text;
    }
    public String verifsession(){
        String user= (String) session.getAttribute("utilisateur");
        if(user!=null) {
            return user;
        }
        else{
            return null;
        }
    }

    public void setsession(HttpSession session) {
        this.session=session;
    }
}

