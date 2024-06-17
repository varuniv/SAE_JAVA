package main;

import java.util.Random;

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
    
    /**
     * @param equipeA première équipe
     * @param equipeB deuxième équipe
     * @param epreuve l'epreuve sur laquelle s'affronte l'équipe
     * @return le gagnant de l'affrontement
     */
    @Override
    public Participant methodeCalculeVainqueur(Participant equipeA, Participant equipeB, Epreuve epreuve){
        double scoreA = epreuve.calculeResultatEquipe(equipeA);
        double scoreB = epreuve.calculeResultatEquipe(equipeB);
        Random rand = new Random();
        int nombreAleatoire = 50 + rand.nextInt(21);
        int pointA = 0;
        int pointB = 0;
        for(int i = 0; i < nombreAleatoire; i++){
            double total = scoreA + scoreB;
            Double randomNum = rand.nextDouble()*total;
            if (randomNum < scoreA) {pointA++;} 
            else {pointB++;}
        }
        if (pointA > pointB){
            return equipeA;
        }
        else if (pointA < pointB){
            return equipeB;
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
