public abstract class Sport {
    protected String nom;
    protected boolean collectif;
    protected int nbJoueur;

    /**
     * @param nom le nom du sport
     * @param collectif si le sport est collectif
     * @param nbJoueur le nombre de joueurs du sport
     */
    protected Sport(String nom, boolean collectif, int nbJoueur) {
        this.nom = nom;
        this.collectif = collectif;
        this.nbJoueur = nbJoueur;
    }

    protected Sport(String nom, int nbJoueur){
        this.nom = nom;
        this.nbJoueur = nbJoueur;
    }

    protected Sport(String nom){
        this.nom = nom;
    }

    /**
     * @return le nom du sport
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @return si le sport est collectif
     */
    public boolean estCollectif(){
        return this.collectif;
    }

    /**
     * @return le nombre de joueurs nécessaires dans le sport
     */
    public int getNbJoueur() {
        return this.nbJoueur;
    }

    /**
     * @param nbJoueur
     */
    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }


    /**
     * @return le string représentant un sport
     */
    @Override
    public String toString() {
        String res = "Sport: " + this.getNom();
        if (this.estCollectif()) {
            res += ", Collectif: Oui";
            
        }
        
        if (!this.estCollectif()) {
            res += ", Collectif: Non";
            
        }
        res += ", Nombre de Joueurs: " + this.getNbJoueur();
        return res;
    }

    public abstract Participant methodeCalculeVainqueur(Participant participent1,Participant participant, Epreuve epreuve );

    public abstract double methodeCalculePerf(double score);
}