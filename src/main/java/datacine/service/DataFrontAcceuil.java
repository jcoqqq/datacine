package datacine.service;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class DataFrontAcceuil {
    Dictionary<String, String> monDictionnaire   = new Hashtable<String, String>();
    private String html;

    public void film() {
        monDictionnaire.put("/film/0", "hello");
        monDictionnaire.put("/film/1", "2bon");
        monDictionnaire.put("/film/3", "3test");
        monDictionnaire.put("/film/4", "4hello");
        monDictionnaire.put("/film/5", "5bonjour");
        monDictionnaire.put("/film/6", "6test");
        generateHtml();

    }

    public String gethtml() {
        return html;
        //return "Mon HTML Mon HTML2"; // Retourne une chaîne de caractères contenant du texte brut

    }

    public void generateHtml(){
        Enumeration<String> e = monDictionnaire.keys();
        html = "<tr>";
        int i=1;
        while (e.hasMoreElements()) {

            // Getting the key of a particular entry
            String key = e.nextElement();
            String value = monDictionnaire.get(key);
            html+="<td><a href='"+key+"'><img src='/image"+key+"' </a></br><p>"+value+"</p></td>";

            if(i%3==0){
                html+="</tr><tr>";
            }
            i=i+1;


        }
        html+="</tr>";

    }

    public void search(String search) {

        monDictionnaire.put("/film/0", "film a "+search);
        monDictionnaire.put("/film/8", "film v");
        monDictionnaire.put("/film/5", "3test");
        monDictionnaire.put("/film/4", "4hello");
        monDictionnaire.put("/film/10", "5bonjour");
        monDictionnaire.put("/film/13", "6test");
        generateHtml();
    }
}
