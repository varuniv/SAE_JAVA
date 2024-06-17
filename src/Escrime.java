import java.util.Random;

public class Escrime extends Sport{
    private String typeEpee;

    /**
     * Constructeur pour la classe Escrime.
     * 
     * @param nom Le nom du sport.
     * @param collectif true si c'est un sport collectif, false sinon.
     * @param nbJoueur Le nombre de joueurs.
     * @param typeEpee Le type d'épée utilisé dans l'escrime.
     */
    public Escrime (String nom, boolean collectif, int nbJoueur, String typeEpee) {
        super(nom, collectif, nbJoueur);
        this.typeEpee = typeEpee;
    }

    /**
     * Retourne le type d'épée utilisé dans l'escrime.
     * @return Le type de l'épée
     */
    public String getEpee() {
        return this.typeEpee;
    }

    @Override
    public String toString(){
        String res = this.getNom()+": "+this.getNbJoueur()+", Type de l'épée: "+this.typeEpee;
        return res;
    }
    
    @Override
    public Participant methodeCalculeVainqueur(Participant athleteA, Participant athleteB, Epreuve epreuve){
        double scoreA = epreuve.calculeResultat(athleteA);
        double scoreB = epreuve.calculeResultat(athleteB);
        Random rand = new Random();
        int pointA = 0;
        int pointB = 0;
        while(pointA < 15 && pointB < 15){
            double total = scoreA + scoreB;
            Double randomNum = rand.nextDouble()*total;
            if (randomNum < scoreA) {pointA++;} 
            else {pointB++;}
        }
        if(pointA > pointB){
            return athleteA;
        }
        else if(pointB > pointA){
            return athleteB;
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


