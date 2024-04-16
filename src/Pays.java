import java.util.ArrayList;
import java.util.List;

public class Pays implements MeilleurAthlete {
    private String nom;
    private List<Athlete> athletes;

    public Pays(String nom){
        this.nom = nom;
        this.athletes = new ArrayList<>();
    }

    public String getNom() {
        return this.nom;
    }

    public void ajouteAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }

    public int nbMedailleOr(){
        return 0;
    }
    public int nbMedailleArgent(){
        return 0;
    }
    public int nbMedailleBronze(){
        return 0;
    }
    public int nbMedaillesTotales(){
        return 0;
    }
    public void meilleurAthlete(){

    }
}
