public class Athletisme extends Sport{
    private int distance;

    /**
     * @param nom
     * @param collectif
     * @param nbJoueur
     * @param distance
     */
    public Athletisme(String nom, boolean collectif, int nbJoueur, int distance) {
        super(nom, collectif, nbJoueur);
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

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

    @Override
    public Participant methodeCalculeVainqueur(Participant participantA, Participant participantB, Epreuve epreuve){
        return null;
    }
}
