import java.util.List;
import java.util.ArrayList;

public class Athlete{
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    private boolean participeACompetition;
    private int placement;
    private Pays pays;
    private List<Medaille> lesMedailles;
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
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance, boolean participeALaCompetition, int placement, Pays pays, List<Medaille> lesMedailles, List<Epreuve> lesEpreuves){
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.participeACompetition = participeALaCompetition;
        this.placement = placement;
        this.lesMedailles = lesMedailles;
        this.lesEpreuves = lesEpreuves;
    }

    /**
     * @param uneMedaille
     */
    public void ajouteMedaille(Medaille uneMedaille){

    }

    /**
     * @param uneEpreuve
     */
    public void ajouteEpreuve(Epreuve uneEpreuve){

    }

    /**
     * @return le placement de l'athlète dans le classement
     */
    public int getPlacement(){
        return 0;
    }
}