import java.util.ArrayList;
import java.util.List;

public class Epreuve {
    private List<Equipe> equipes;
    private List<Athlete> athletes;
    private String nom;
    private String categorie;
    private boolean estEnEquipe;
    private Sport sport;

    /**
     * @param nom
     * @param sport
     * @param categorie
     * @param estEnEquipe
     */
    public Epreuve( String nom, Sport sport, String categorie, boolean estEnEquipe){
        this.nom = nom;
        this.sport = sport;
        this.categorie = categorie;
        this.estEnEquipe = estEnEquipe;
        this.equipes = new ArrayList<>();
        this.athletes = new ArrayList<>();
    }

    /**
     * @param athlete
     */
    public void ajouteUnAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }

    /**
     * @param equipe
     */
    public void ajouteUneEquipe(Equipe equipe){
        this.equipes.add(equipe);
    }

    /**
     * @return la liste des équipes participants à l'épreuve
     */
    public List<Equipe> getEquipes() {
        return equipes;
    }

    /**
     * @param equipes
     */
    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    /**
     * @return la liste des athlètes participants à l'épreuve
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }

    /**
     * @param athletes
     */
    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    /**
     * @return le nom de l'équipe
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return la catégorie de l'équipe
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * @param categorie
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * @return si l'épreuve est en équipe
     */
    public boolean estEnEquipe() {
        return estEnEquipe;
    }

    /**
     * @param estEnEquipe
     */
    public void setEstEnEquipe(boolean estEnEquipe) {
        this.estEnEquipe = estEnEquipe;
    }

    /**
     * @return le sport correspondant à l'épreuve
     */
    public Sport getSport() {
        return sport;
    }

    /**
     * @param sport
     */
    public void setSport(Sport sport) {
        this.sport = sport;
    }


    
}


