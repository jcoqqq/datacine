package datacine.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedirectPage {
    List<String> page = Arrays.asList("connexion", "inscription");


    public String Page(String home) {
            if (home == null) {
                return "index";
            } else {
                int index = page.indexOf(home);
                if (index == -1) {
                    return "index";
                } else {
                    return page.get(index);
                }
            }

        }
    public String chemincss(String fichier)  {
        String chemin="src/main/resources/templates/css/";
        String chemin_complet=chemin+fichier;
        File f = new File(chemin_complet);
        String css = "error file";
        if(f.exists() && !f.isDirectory()) {
            try {
                css = new String(Files.readAllBytes(Paths.get(chemin_complet)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return css;

    }

    public String cheminjs(String fichier) { //à finir
        String chemin = "src/main/resources/templates/js/";
        String chemin_complet = chemin + fichier;
        File f = new File(chemin_complet);
        String js = "error file";
        if (f.exists() && !f.isDirectory()) {
            try {
                js = new String(Files.readAllBytes(Paths.get(chemin_complet)), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return js;
    }
}



