import java.util.List;

public abstract class Sport {
    private String nom;
    private boolean collectif;
    private int nbJoueur;
    private List<Epreuve> epreuves;

    public Sport(String nom, boolean collectif, int nbJoueur) {
        this.nom = nom;
        this.collectif = collectif;
        this.nbJoueur = nbJoueur;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean estCollectif(){
        return this.collectif;
    }

    public int getNbJoueur() {
        return this.nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public void ajouteEpreuve(Epreuve epreuve) {
        this.epreuves.add(epreuve);
    }
}