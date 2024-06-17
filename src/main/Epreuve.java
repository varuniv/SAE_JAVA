package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Epreuve implements MeilleurAthlete{
    private List<Equipe> equipes;
    private List<Athlete> athletes;
    private String nom;
    private String categorie;
    private boolean estEnEquipe;
    private Sport sport;
    private double critereForce;
    private double critereAgilite;
    private double critereEndurance;

    /**
     * @param nom
     * @param sport
     * @param categorie
     * @param estEnEquipe
     */
    public Epreuve( String nom, Sport sport, String categorie, boolean estEnEquipe, double force, double agilite, double endurance){
        this.nom = nom;
        this.sport = sport;
        this.categorie = categorie;
        this.estEnEquipe = estEnEquipe;
        this.equipes = new ArrayList<>();
        this.athletes = new ArrayList<>();
        this.critereForce = force;
        this.critereAgilite = agilite;
        this.critereEndurance = endurance;
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

    @Override
    public String toString(){
        return this.getNom()+"venant du sport : "+this.getSport().toString();
    }
    
    /**
     * @param athlete Un Athlete
     * @return Le resultat en stat d'un athlete dans une epreuve (le max étant 200)
     */
    public double calculeResultat(Participant participant){
        Athlete athlete = (Athlete) participant;
        Random random = new Random();
        double randomDouble = 1.0 + (50.0 - 1.0) * random.nextDouble();
        double res = athlete.getForce()*this.critereForce + athlete.getEndurance()*this.critereEndurance + athlete.getAgilite()+this.critereAgilite+ randomDouble;
        return res;
    }

    /**
     * @param equipe Une Equipe
     * @return Le resultat en stat d'une equipe dans une epreuve (le max étant 200)
     */
    public double calculeResultatEquipe(Participant equipe){
        double res = 0;
        Equipe particip = (Equipe) equipe;
        for(Athlete athlete : particip.getMembres()){
            res += calculeResultat(athlete);
        }
        return res/particip.getMembres().size();
    }

    /**
     *@return Le meilleur athlète de l'épreuve.
     */
    public Athlete meilleurAthlete(){
        Athlete goat = null;
        for(Athlete athlete: this.athletes){
            if (goat == null){
                goat = athlete;
            }
            else{
                if(goat.getMedailles().get("Or") < athlete.getMedailles().get("Or")){
                    goat = athlete;
                }
                else{
                    if(goat.getMedailles().get("Or") == athlete.getMedailles().get("Or")){
                        if(goat.getMedailles().get("Argent") < athlete.getMedailles().get("Argent")){
                            goat = athlete;
                        }
                        else{
                            if(goat.getMedailles().get("Argent") == athlete.getMedailles().get("Argent")){
                                if(goat.getMedailles().get("Bronze") < athlete.getMedailles().get("Bronze")){
                                    goat = athlete;
                                }
                                else{
                                    if(goat.getMedailles().get("Bronze") == athlete.getMedailles().get("Bronze")){
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return goat;
    }
}


