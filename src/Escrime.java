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
    
}


