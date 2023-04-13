package datacine.service;

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

    public void setidcommentaire(String idfilm,String idcommentaire, String type) {
        this.idcommentaire=idcommentaire;
        this.type=type;
        this.idfilm=idfilm;
    }

    public String deletefilm() {
        return "delete "+idcommentaire+" "+type;
    }
}
