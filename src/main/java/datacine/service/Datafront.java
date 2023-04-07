package datacine.service;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Datafront {
    Dictionary<Integer, String> monDictionnaire   = new Hashtable<Integer, String>();
    private String html;

    public void film() {
        monDictionnaire.put(0, "hello");
        monDictionnaire.put(1, "2bon");
        monDictionnaire.put(2, "3test");
        monDictionnaire.put(3, "4hello");
        monDictionnaire.put(4, "5bonjour");
        monDictionnaire.put(5, "6test");
        System.out.println("hello");
        generateHtml();

    }

    public String gethtml() {
        return html;
        //return "Mon HTML Mon HTML2"; // Retourne une chaîne de caractères contenant du texte brut

    }

    public void generateHtml(){
        Enumeration<Integer> e = monDictionnaire.keys();
        html = "<tr>";
        int i=1;
        while (e.hasMoreElements()) {

            // Getting the key of a particular entry
            int key = e.nextElement();
            String value = monDictionnaire.get(key);
            html+="<td><a href='chemin/"+key+"'><img src='chemin/"+key+"' </a></br><p>"+value+"</p></td>";

            if(i%3==0){
                html+="</tr><tr>";
            }
            i=i+1;


        }
        html+="</tr>";

    }

    public void search(String search) {

        monDictionnaire.put(0, "film a "+search);
        monDictionnaire.put(8, "film v");
        monDictionnaire.put(5, "3test");
        monDictionnaire.put(4, "4hello");
        monDictionnaire.put(10, "5bonjour");
        monDictionnaire.put(13, "6test");
        generateHtml();
    }
}
