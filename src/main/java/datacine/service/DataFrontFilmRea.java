package datacine.service;

import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        String chemin="/"+type+"/"+id;
        String urlStr = "http://localhost:8081/backutilisateur/description?id="+id;

        String httpResponse = "[]";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            System.out.println("Status: " + status);
            System.out.println("Réponse: " + content.toString());
            httpResponse = content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String description=httpResponse;

        String text="<div class=\"images\">\n" +
                "    <img class=\"image-miniature\" src=\"/image"+chemin+"\" alt=\"Image 1\">\n" +
                "    <div>\n" +


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
       String chemin="http://localhost:8081/proxy/commentaire/delete?id_film=2&type=film&id_commentaire=";
        String urlStr = "http://localhost:8081/backutilisateur/getcommentaire?id="+id;

        String httpResponse = "[]";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            System.out.println("Status: " + status);
            System.out.println("Réponse: " + content.toString());
            httpResponse = content.toString();
            System.out.println(httpResponse);

        Dictionary<String, String> monDictionnaire = new Hashtable<String, String>();

        // Division de la chaîne JSON en paires clé-valeur
        String[] keyValuePairs = httpResponse.replace("{", "")
                .replace("}", "").replace("\"","")
                .split(",");

        // Parcours des paires clé-valeur
        for (String pair : keyValuePairs) {
            // Division de chaque paire en clé et valeur
            String[] keyValue = pair.split(":");
            String key = keyValue[0];
            String value = keyValue[1]+" note : "+keyValue[2]+"/5";

            // Construction de la clé modifiée
            String modifiedKey = chemin+key;

            // Ajout de la paire clé-valeur au dictionnaire
            monDictionnaire.put(modifiedKey, value);

        }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

