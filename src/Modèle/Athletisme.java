public class Athletisme extends Sport{
    private int distance;

    /**
     * @param nom
     * @param collectif si c'est un sport collectif
     * @param nbJoueur nombre de joueur pour ce sport
     * @param distance distance qu'un athlete doit courrir
     */
    public Athletisme(String nom, boolean collectif, int nbJoueur, int distance) {
        super(nom, collectif, nbJoueur);
        this.distance = distance;
    }

    /**
     * @return la distance que doit courrir l'athlete
     */
    public int getDistance() {
        return this.distance;
    }

    /**
     * @return la manière d'afficher le sport.
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

    /**
     * @param score score du nageur ou de l'équipe 
     * @return renvoie un temps pour le nageur ou de l'équipe en fonction de leur score.
     */
    public double methodeCalculePerf(double score){
        return (1600-score*1.5)*(this.getDistance()/100);
    }

    /**
     * @return rien car c'est un sport demandant des performance et non des matchs.
     */
    @Override
    public Participant methodeCalculeVainqueur(Participant participantA, Participant participantB, Epreuve epreuve){
        return null;
    }
}
