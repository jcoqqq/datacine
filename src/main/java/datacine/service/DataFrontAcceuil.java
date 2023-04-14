package datacine.service;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFrontAcceuil {
    Dictionary<String, String> monDictionnaire   = new Hashtable<String, String>();
    private String html;
    private HttpSession session;

    public void film() {

        String urlStr = "http://localhost:8081/backutilisateur/film";

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
            String value = keyValue[1];

            // Construction de la clé modifiée
            String modifiedKey = "/film/"+key+"";

            // Ajout de la paire clé-valeur au dictionnaire
            monDictionnaire.put(modifiedKey, value);

        }
        System.out.println(monDictionnaire);
        generateHtml(monDictionnaire);
    }

        public String gethtml() {
        return html;
        //return "Mon HTML Mon HTML2"; // Retourne une chaîne de caractères contenant du texte brut

    }

    public void generateHtml(Dictionary<String, String> monDictionnaires){
        Enumeration<String> e = monDictionnaires.keys();
        System.out.println(monDictionnaires +" sortie 2");
        html = "<tr>";
        int i=1;
        while (e.hasMoreElements()) {


            // Getting the key of a particular entry
            String key = e.nextElement();
            System.out.println(key);
            String value = monDictionnaires.get(key);
            html+="<td><a href='"+key+"'><img class=\"image-miniature\" src='/image"+key+"' </a></br><p>"+value+"</p></td>";

            if(i%3==0){
                html+="</tr><tr>";
            }
            i=i+1;


        }
        html+="</tr>";

    }

    public void searchex(String search) {

        monDictionnaire.put("/film/1", "film a "+search);
        monDictionnaire.put("/film/2", "film v");
        monDictionnaire.put("/film/5", "3test");
        monDictionnaire.put("/film/4", "4hello");
        monDictionnaire.put("/film/10", "5bonjour");
        monDictionnaire.put("/film/13", "6test");
        System.out.println(monDictionnaire);
        generateHtml(monDictionnaire);
    }
    public void search(String nom){
        String urlStr = "http://localhost:8081/backutilisateur/searchfilm?nom="+nom;

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
            String value = keyValue[1];

            // Construction de la clé modifiée
            String modifiedKey = "/film/"+key+"";

            // Ajout de la paire clé-valeur au dictionnaire
            monDictionnaire.put(modifiedKey, value);

        }
        System.out.println(monDictionnaire+ "test dico");
        generateHtml(monDictionnaire);
    }

    public String setjson(String chaine) {
        if (chaine.equals("null")) {
            return "[]";
        } else {
            String jsonData = "[\n" +
                    "    {\n" +
                    "        \"index\": \"/film/1\",\n" +
                    "        \"value\": \"exemple : sonic\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"index\": \"/film/2\",\n" +
                    "        \"value\": \"exemple : avatar\"\n" +
                    "    },\n" +

                    "    {\n" +
                    "        \"index\": \"/film/3\",\n" +
                    "        \"value\": \"exemple : uncharted\"\n" +
                    "    }\n" +
                    "]";
            return jsonData;
        }
    }

    public  String transformJson(String nom) {
        String json = null; //appeler précedement l'api mais ne fonctionne pas
        String[] elements = json.replaceAll("[{}\"]", "").split(",");

        StringBuilder builder = new StringBuilder();
        builder.append("[\n");

        for (String element : elements) {
            builder.append("  {")
                    .append(element)
                    .append("},\n");
        }

        builder.deleteCharAt(builder.length() - 2);
        builder.append("]");

        String result = builder.toString();

        return result;
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
