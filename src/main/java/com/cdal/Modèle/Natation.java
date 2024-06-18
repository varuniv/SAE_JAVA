package main.java.com.cdal.Modèle;

public class Natation extends Sport {
    private int distance;

    /**
     * Initialise un nouvel objet Natation.
     * 
     * @param nom Le nom du sport.
     * @param collectif Indique si c'est un sport collectif ou non.
     * @param nbJoueur Le nombre de joueurs.
     * @param distance La distance de la course en mètres.
     */
    public Natation(String nom, boolean collectif, int nbJoueur, int distance) {
        super(nom, collectif, nbJoueur);
        this.distance = distance;
    }

    /**
     * Renvoie la distance sur laquelle les athlètes doivent nager.
     * 
     * @return la distance sur laquelle les athlètes doivent nager
     */
    public int getDistance() {
        return this.distance;
    }

    /**
     * @param score score du nageur ou de l'équipe 
     * @return renvoie un temps pour le nageur ou de l'équipe en fonction de leur score.
     */
    @Override
    public double methodeCalculePerf(double score){
        return (800-score)*(this.getDistance()/100);
    }

    /**
     * @return rien car c'est un sport demandant des performance et non des matchs.
     */
    @Override
    public Participant methodeCalculeVainqueur(Participant participantA, Participant participantB, Epreuve epreuve){
        return null;
    }

    /**
     * @return le string représentant Natation
     */
    @Override
    public String toString(){
        String estCollectif = "Oui";
        if(!(this.estCollectif())){
            estCollectif = "Non";
        }
        String res = "Sport : "+ this.getNom() + ", Collectif: "+estCollectif+", Nombre de joueurs: "+this.getNbJoueur()+", Distance: "+this.distance; 
        return res;
    }
}
