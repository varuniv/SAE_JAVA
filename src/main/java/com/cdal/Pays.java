package main.java.com.cdal;

import java.util.ArrayList;
import java.util.List;

public class Pays implements MeilleurAthlete {
    private String nom;
    private List<Athlete> athletes;
    private List<Equipe> equipes; 

    /**
     * @param nom
     */
    public Pays(String nom){
        this.nom = nom;
        this.athletes = new ArrayList<>();
        this.equipes = new ArrayList<>();
    }

    /**
     * @return le nom du pays
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @return les equipes du Pays
     */
    public List<Equipe> getEquipes(){
        return this.equipes;
    }

    /**
     * @param equipe l'équipe a ajouté dans le Pays
     */
    public void ajouteEquipe(Equipe equipe){
        this.equipes.add(equipe);
    }

    
    /**
     * @return la liste des athlètes qui sont dans le pays. 
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }
    
    /**
     * @param athlete qui va etre ajouté au pays
     */
    public void ajouteAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }
    /**
     * @return le nombre de médailles d'or
     */
    public int nbMedailleOr(){
        Integer or = 0;
        for (Athlete athlete: this.athletes){
            or += athlete.getMedailles().get("Or");
        }
        return or;
    }

    /**
     * @return le nombre de médailles d'argent
     */
    public int nbMedailleArgent(){
        Integer argent = 0;
        for (Athlete athlete: this.athletes){
            argent += athlete.getMedailles().get("Argent");
        }
        return argent;
    }

    /**
     * @return le nombre de médailles de bronze
     */
    public int nbMedailleBronze(){
        Integer bronze = 0;
        for (Athlete athlete: this.athletes){
            bronze += athlete.getMedailles().get("Bronze");
        }
        return bronze;
    }

    /**
     * @return le nombre de médailles obtenues par le pays
     */
    public int nbMedaillesTotales(){
        return this.nbMedailleBronze()+this.nbMedailleArgent()+this.nbMedailleOr();
    }

    /**
     * @return le string de la représentation du Pays
     */
    @Override
    public String toString(){
        return this.getNom() + " possede " + this.nbMedaillesTotales() +
        " dont " +this.nbMedailleOr() + " médailles d'or " + this.nbMedailleArgent() + " médailles d'argent " + this.nbMedailleBronze() + " médailles de bronze" ;
    }

    /**
     * @return le meilleur athlete en terme de médaille du pays.
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
                            }
                        }
                    }
                }
            }
        }
        return goat;
    }

    /**
     * @param o Objet a comparé
     * @return si o est égal au Pays
     */
    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null){return false;}
        if(!(o instanceof Pays)){return false;}
        Pays tmp = (Pays) o;
        return tmp.getNom().equals(this.getNom()) && tmp.getAthletes().equals(this.getAthletes());
    }
    
}
