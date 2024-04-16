import java.util.ArrayList;
import java.util.List;

public class Epreuve {
    private List<Equipe> equipes;
    private List<Athlete> athletes;
    private String nom;
    private String categorie;
    private boolean estEnEquipe;
    private Sport sport;


    public Epreuve( String nom, Sport sport, String categorie, boolean estEnEquipe){
        this.nom = nom;
        this.sport = sport;
        this.categorie = categorie;
        this.estEnEquipe = estEnEquipe;
        this.equipes = new ArrayList<>();
        this.athletes = new ArrayList<>();
    }

    public void ajouteUnAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }

    public void ajouteUneEquipe(Equipe equipe){
        this.equipes.add(equipe);
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public boolean isEstEnEquipe() {
        return estEnEquipe;
    }

    public void setEstEnEquipe(boolean estEnEquipe) {
        this.estEnEquipe = estEnEquipe;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }


    
}


