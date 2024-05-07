import java.util.List;
import java.util.ArrayList;

public class Athlete implements Participant, Medaille{
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    private boolean participeACompetition;
    private int placement;
    private Pays pays;
    private List<String> lesMedailles;
    private List<Epreuve> lesEpreuves;

    /**
     * @param nom
     * @param prenom
     * @param sexe
     * @param force
     * @param agilite
     * @param endurance
     * @param participeALaCompetition
     * @param placement
     * @param pays
     * @param lesMedailles
     * @param lesEpreuves
     */
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance, int placement, Pays pays){
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.participeACompetition = false;
        this.placement = placement;
        this.lesMedailles = new ArrayList<>();
        this.lesEpreuves = new ArrayList<>();
    }

    /**
     * @return le nom de l'athlète
     */
    public String getNom(){
        return this.nom;
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
    public int getForce(){
        return this.force;
    }

    /**
     * @return l'agilité de l'athlète
     */
    public int getAgilite(){
        return this.agilite;
    }

    /**
     * @return l'endurance de l'athlète
     */
    public int getEndurance(){
        return this.endurance;
    }

    /**
     * @return les médailles de l'athlète
     */
    public List<String> getMedailles(){
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
     * @param uneEpreuve
     */
    public void ajouteEpreuve(Epreuve uneEpreuve){
        this.lesEpreuves.add(uneEpreuve);
    }

    @Override
    public void participer(){
        this.participeACompetition = true;
    }

    @Override
    public void gagne(String typeMedaille){
        this.lesMedailles.add(typeMedaille);
    }
}