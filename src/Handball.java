import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Handball extends Sport{
    /**
     * Constructeur pour la classe Handballssss.
     * 
     * @param nom Le nom du sport.
     * @param collectif true si c'est un sport collectif, false sinon.
     * @param nbJoueur Le nombre de joueurs.
     */
    public Handball(String nom, boolean collectif, int nbJoueur) {
        super(nom, collectif, nbJoueur);
    }
    
    public List<Integer> methodeCalcule(double scoreA, double scoreB){
        Random rand = new Random();
        int nombreAleatoire = 50 + rand.nextInt(21);
        int pointA = 0;
        int pointB = 0;
        for(int i = 0; i < nombreAleatoire; i++){
            double total = scoreA + scoreB;
            Double randomNum = rand.nextDouble(total);
            if (randomNum < scoreA) {pointA++;} 
            else {pointB++;}
        }
        List<Integer> points = new ArrayList<>();
        points.add(pointA);
        points.add(pointB);
        return points;
    }
}
