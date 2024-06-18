package main.java.com.cdal.Modèle;

import java.util.ArrayList;
import java.util.List;

public class Equipe implements Participant{

    private String nomEquipe;
    private boolean participee;
    private Epreuve epreuve;
    private List<Athlete> membres;
    private boolean estPrete = false; 
    private Pays pays;
    private String genre;

    /**
     * @param nomEquipe  nom de l'équipe
     * @param epreuve  une épreuve à laquelle l'équipe participe
     * @param participee si elle peut participer ou pas à une épreuve en fonction de son nombre d'athlètes.
     * @param pays le pays de l'équipe
     * @param genre le genre de l'équipe ("M" ou "F")
     */
    public Equipe(String nomEquipe, Epreuve epreuve, Pays pays, String genre) throws PasCollectifException, PasUnSexeException{
        if(epreuve.estEnEquipe()){
        this.nomEquipe = nomEquipe;
        this.epreuve = epreuve;
        this.participee = false;
        this.membres = new ArrayList<>();
        this.pays = pays;
        if(genre.equals("M") || genre.equals("F")){this.genre = genre;}
        else{throw new PasUnSexeException();}
        }
        else{throw new PasCollectifException();}
    }

    /**
     * @return le nom de l'equipe
     */
    public String getNomEquipe() {
        return this.nomEquipe;
    }

    /**
     * @param nomEquipe le nom de l'équipe
     */
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    /**
     * @return si l'equipe participe
     */
    public boolean isParticipee() {
        return this.participee;
    }

    /**
     * @return l'epreuve de l'équipe
     */
    public Epreuve getEpreuve() {
        return this.epreuve;
    }

    /**
     * @return la liste des athletes de l'equipe
     */
    public List<Athlete> getMembres() {
        return this.membres;
    }

    /**
     * @return si l'equipe a assez de membres pour participer à l'épreuve
     */
    public boolean estPrete() {
        return this.estPrete;
    }

    /**
     * Permet de savoir si une équipe est prête en terme de nombre de joueurs
     */
    public void setEstPrete() {
        if (membres.size()<this.getEpreuve().getSport().getNbJoueur()){
            this.estPrete = false;
        }
        else{        
            this.estPrete = true;
        }
    }

    /**
     * @return le pays de cette équipe
     */
    public Pays getPays(){
        return this.pays;
    }

    /**
     * @return le genre de cette équipe
     */
    public String getGenre(){
        return this.genre;
    }
    
    /**
     * @param athlete un Athlete
     */
    public void ajouteMembre( Athlete athlete) throws MauvaiseEquipeException{
        this.setEstPrete();
        boolean pret = this.estPrete;
        if(athlete.getPays().equals(this.getPays()) && athlete.getSexe().equals(this.getGenre())){
            if(!(pret)){
                this.membres.add(athlete);
                if(this.epreuve != null){
                    athlete.ajouteEpreuve(this.getEpreuve());
                    athlete.setEquipe(this);
                }
                }
        }
        else{
            throw new MauvaiseEquipeException();
        }
    }

    /**
     * donne une médaille à chaque membre d'une équipe
     * @param medaille la médaille qui va être ajoutée
     */
    public void DonnerMedaille(String medaille){

        for (Athlete ath : this.membres) {
            ath.gagne(medaille);
        }
    }
    
    /**
     * @param compet Une Competition en Equipe
     * @return Si l'équipe a été ajouté
     */
    @Override
    public boolean participer(Competition compet) {
        if( compet.ajoute(this)){
            this.participee = true;
            return true;
        }
        return false;
    }

    /**
     * @return renvoie le String représentant l'épreuve
     */
    @Override
    public String toString(){
        return "L'équipe:"+ this.nomEquipe+" a participé à l'épreuve :"+this.epreuve;
    }
    
    /**
     * @param obj l'objet à comparée
     * @return booleen si l'équipe est la même que obj
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof Equipe){
            Equipe other = (Equipe) obj;
            return this.nomEquipe.equals(other.nomEquipe) && this.membres.equals(other.membres) ;
        }
        return false;
    }
}
    
