package datacine.service;

public class FormulaireProxy {
    Boolean formulairevalide=false;
    private boolean admin=false;

    public Boolean getFormulairevalide() {
        return formulairevalide;
    }

    public String setinscription(String utilisateur, String mail, String password) {
        System.out.println(utilisateur);
        if(utilisateur.equals("test")){
            formulairevalide=false;
            return "compte existant";


        }
        else {
            formulairevalide = true;

            return "compte créé";
        }
    }

    public Boolean setconnexion(String utilisateur, String password) {
        if(utilisateur.equals("test")){
            admin=true;
            return true;
        }
        else {
            return false;
        }
    }
    public  Boolean admin(){
        return admin;
    }
}
