package datacine.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class FormulaireProxy {
    Boolean formulairevalide=false;
    private boolean admin=false;
    private String idcommentaire;
    private String idfilm;

    private String type;

    public Boolean getFormulairevalide() {
        return formulairevalide;
    }

    public String setinscription(String utilisateur, String mail, String password) {
        System.out.println(utilisateur);
        String urlStr = "http://localhost:8081/backutilisateur/inscription?user=" + utilisateur  + "&password=" + password+ "&mail=" + mail;

        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

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
            if(content.toString().contains("compte cree")){
                formulairevalide=true;
            }
            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
            return "error";

    }

    public Boolean setconnexion(String utilisateur, String password) {
        String urlStr = "http://localhost:8081/backutilisateur/connexion?user=" + utilisateur + "&password=" + password;

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
            if(content.toString().split(",")[0].equals("1")){
                admin= Boolean.parseBoolean(content.toString().split(",")[1]);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    public  Boolean admin(){
        return admin;
    }

    public void setidcommentaire(String idfilm,String idcommentaire, String type) {
        this.idcommentaire=idcommentaire;
        this.type=type;
        this.idfilm=idfilm;
    }

    public String deletefilm() {
        return "delete "+idcommentaire+" "+type;
    }
}
