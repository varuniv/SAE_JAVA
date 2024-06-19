import java.util.Random;

public class VolleyBall extends Sport {

    /**
     * @param nom le nom du sport
     * @param collectif si le sport est collectif
     * @param nbJoueur le nombre de joueurs du sport
     */
    public VolleyBall(String nom, int nbJoueur) {
        super(nom, nbJoueur);
        this.collectif = true;
    }
    
    /**
     * @param scoreA score de l'équipe A
     * @param scoreB score de l'équipe B
     * @return Une liste contenant les points de l'équipe A et de l'équpe B.
     */
    @Override
    public Participant methodeCalculeVainqueur(Participant participantA, Participant participantB, Epreuve epreuve){
        double scoreA = epreuve.calculeResultatEquipe(participantA);
        double scoreB = epreuve.calculeResultatEquipe(participantB);
        Random rand = new Random();
        int pointA = 0;
        int pointB = 0;
        while(pointA < 3 && pointB < 3){
            double total = scoreA + scoreB;
            Double randomNum = rand.nextDouble()*total;
            if (randomNum < scoreA) {pointA++;} 
            else {pointB++;}
        }
        if (pointA > pointB){
            return participantA;
        }
        if (pointA < pointB){
            return participantB;
        }
        return null;
    }

    /**
     * @return le score mis en paramètre car c'est un sport opposant 2 parties et non de performances individuelles.
     */
    @Override
    public double methodeCalculePerf(double score){
        return score;
    }
}
