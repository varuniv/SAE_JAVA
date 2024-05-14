import java.util.ArrayList;
import java.util.List;

public class Pays implements MeilleurAthlete {
    private String nom;
    private List<Athlete> athletes;

    /**
     * @param nom
     */
    public Pays(String nom){
        this.nom = nom;
        this.athletes = new ArrayList<>();
    }

    /**
     * @return le nom du pays
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @param athlete
     */
    public void ajouteAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }
    /**
     * @return le nombre de médailles d'or
     */
    public int nbMedailleOr(){
        return 0;
    }

    /**
     * @return le nombre de médailles d'argent
     */
    public int nbMedailleArgent(){
        return 0;
    }

    /**
     * @return le nombre de médailles de bronze
     */
    public int nbMedailleBronze(){
        return 0;
    }

    /**
     * @return le nombre de médailles obtenues par le pays
     */
    public int nbMedaillesTotales(){
        return 0;
    }
    
    /**
     * À FAIRE
     */
    public Athlete meilleurAthlete(){
        return null;
    }
}
