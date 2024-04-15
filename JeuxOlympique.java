import java.util.ArrayList;
import java.util.List;

public class JeuxOlympique implements MeilleurAthlete {
    
    private List<Pays> pays;
    private String nom;
    
   
    public JeuxOlympique(String nom) {
        this.nom = nom;
        this.pays = new ArrayList<>();
    }

    public String getNom() {
        return this.nom;
    }

    public void ajoutePays(Pays Pays){

    }

    @Override
    public Athlete meilleurAthlete() {
        List<Athlete> lisA = new ArrayList<>();
        for (Pays paysyemp : pays) {
            lisA.add(paysyemp.meilleurAthlete());
        }
        return null;
    } 

   
}
