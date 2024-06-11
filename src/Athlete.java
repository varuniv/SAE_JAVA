import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Athlete implements Participant, Medaille{
    private String nom;
    private String prenom;
    private String sexe;
    private double force;
    private double agilite;
    private double endurance;
    private boolean participeACompetition;
    private int placement;
    private Pays pays;
    private Map<String,Integer> lesMedailles;
    private List<Epreuve> lesEpreuves;

    /**
     * Constructeur de la classe Athlete
     * @param nom le nom de l'athlète
     * @param prenom le prénom de l'athlète
     * @param sexe le sexe de l'athlète F ou M
     * @param force la valeur de la force de l'athlète entre 1 et 20
     * @param agilite la valeur de l'agilité de l'athlète 1 et 20
     * @param endurance la valeur de l'endurance de l'athlète 1 et 20
     * @param participeALaCompetition si l'athlète participe à la compétition
     * @param placement la position dans le classement de l'athlète
     * @param pays le pays de l'athlète
     * @param lesMedailles le dictionnaire des médailles de l'athlète
     * @param lesEpreuves les épreuves auxquelles participe l'athlète
     */
    public Athlete(String nom, String prenom, String sexe, double force, double agilite, double endurance, Pays pays){
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.participeACompetition = false;
        this.lesMedailles = new HashMap<>();
        this.lesEpreuves = new ArrayList<>();

        this.lesMedailles.put("Or", 0);
        this.lesMedailles.put("Argent", 0);
        this.lesMedailles.put("Bronze", 0);
    }

    /**
     * @return le nom de l'athlète
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * @return est ce que le participant participe  à une competition
     */
    public boolean getParticipeACompetition(){
        return this.participeACompetition;
    }

    /**
     * @return pays de l'Athlete
     */
    public Pays getPays(){
        return this.pays;
    }
    /**
     * @return le prénom de l'athlète
     */
    public String getPrenom(){
        return this.prenom;
    }

    /**
     * @return le sexe de l'athlète
     */
    public String getSexe(){
        return this.sexe;
    }

    /**
     * @return la force de l'athlète
     */
    public double getForce(){
        return this.force;
    }

    /**
     * @return l'agilité de l'athlète
     */
    public double getAgilite(){
        return this.agilite;
    }

    /**
     * @return l'endurance de l'athlète
     */
    public double getEndurance(){
        return this.endurance;
    }

    /**
     * @return les médailles de l'athlète
     */
    public Map<String,Integer> getMedailles(){
        return this.lesMedailles;
    }

    /**
     * @return les épreuves auxquelles participe l'athlète
     */
    public List<Epreuve> getEpreuves(){
        return this.lesEpreuves;
    }

    /**
     * @return le placement de l'athlète dans le classement
     */
    public int getPlacement(){
        return this.placement;
    }

    /**
     * Ajoute une épreuve à la liste des épreuves
     * @param uneEpreuve une épreuve
     */
    public void ajouteEpreuve(Epreuve uneEpreuve){
        this.lesEpreuves.add(uneEpreuve);
    }

    /**
     * Fait participer l'athlète à la compétition
     */
    @Override
    public void participer(){
        this.participeACompetition = true;
    }

    /**
     * Ajoute une médaille au dictionnaire des médailles
     * @param typeMedaille
     */
    @Override
    public void gagne(String typeMedaille){
        switch(typeMedaille){
            case "Or":
                Integer newOr = this.lesMedailles.get("Or")+1;
                this.lesMedailles.replace("Or", newOr);
                break;
            case "Argent":
                Integer newArgent = this.lesMedailles.get("Argent")+1;
                this.lesMedailles.replace("Argent", newArgent);
                break;
            case "Bronze":
                Integer newBronze = this.lesMedailles.get("Bronze")+1;
                this.lesMedailles.replace("Bronze", newBronze);
        }
    }

    @Override
    public String toString(){
        String res = this.nom+" "+this.prenom+": ["+this.nom+" "+this.prenom+"a une force de "+this.force+", une agilité de "+this.agilite+" et une endurance de "+this.endurance+". Il vient de "+this.pays.getNom()+". Dans le classement il est "+this.placement+" et a "+this.lesMedailles.get("Or")+" médailles d'or, "+this.lesMedailles.get("Argent")+" médailles d'argent et "+this.lesMedailles.get("Bronze")+" médailles de bronze]";
        return res;
    }
}