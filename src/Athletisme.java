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
}
