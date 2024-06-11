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
