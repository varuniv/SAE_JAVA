package main.java.com.cdal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Competition{
    private List<Participant> listeParticipant;
    private Epreuve epreuve;


    /**
     * Constructeur de Competition sans participants de base
     * @param epreuve une epreuve sur laquelle se jouera la compétition
     */
    public Competition(Epreuve epreuve) {
        this.listeParticipant = new ArrayList<>();
        this.epreuve = epreuve;
    }

    /**
     * Constructeur de Competition avec une liste de participants de base
     * @param listeParticipant une liste de participants
     * @param epreuve une epreuve sur laquelle se jouera la compétition
     */
    public Competition(List<Participant> listeParticipant, Epreuve epreuve) {
        this.listeParticipant = listeParticipant;
        this.epreuve = epreuve;
    }
    
    /**
     * @return le list des participents 
     */
    public List<Participant> getListeParticipant() {
        return listeParticipant;
    }

    /**
     * @return l'epreuve de cette competition
     */
    public Epreuve getEpreuve(){
        return this.epreuve;
    }

    /**
     * @param participant Si l'épreuve est collectif il faudra mettre une équipe sinon un athlete 
     * @return true si l'ajout a été effectuer
     */
    public boolean ajoute(Participant participant) {
        boolean res = false;
        if (epreuve.estEnEquipe() && participant  instanceof Equipe){
            this.getListeParticipant().add(participant);
            res = true;
        }
        else{
            if (participant  instanceof Athlete) {
                this.getListeParticipant().add(participant);
                res = true;
            }
        }
        return res;
    }

    /**
     * @return la liste triée des participants de cette épreuve du plus au moins performant
     */
    public List<Participant> ExecutionPerf(){
        Map<Participant, Double> scoresMap = new HashMap<>();
        for (Participant participant : this.getListeParticipant()) {
            double score = this.fairTemps(participant);
            scoresMap.put(participant, score);
        }
        List<Map.Entry<Participant, Double>> entries = new ArrayList<>(scoresMap.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<Participant> sortedParticipants = new ArrayList<>();
        for (Map.Entry<Participant, Double> entry : entries) {
            sortedParticipants.add(entry.getKey());
        }
        return sortedParticipants;
    }

    /** 
     * @return la liste triée des participants de cette épreuve de celui qui a le plus gagné à celui qui a le moins gagné
     */
    public List<Participant> ExecutionPooleEquipe(){
        Map<Participant,List<Participant>> dic = new HashMap<>();
        if (!(listeParticipant.isEmpty())) {
            for (Participant pr1 : this.listeParticipant) {
                dic.put(pr1, new ArrayList<>());
                for (Participant pr2 : this.listeParticipant) {
                    if(!pr1.equals(pr2)){
                        if(!pr1.equals(pr2)){
                            if (jouerMatch(pr1, pr2).equals(pr1)){
                                dic.get(pr1).add(pr2);
                            }
                    }
                }
                }
                
            } 
            List<Participant> listpr  = new ArrayList<>(this.listeParticipant);
            listpr.sort((par,par1) -> dic.get(par).size()-dic.get(par1).size());
            return listpr;
        }
        return null ;
    }

    /**
     * @param partc1 Participant 1
     * @param partc2 Participant 2
     * @return renvoie lequel gagne entre 2 participants à l'épreuve de la compétition
     */
    public Participant jouerMatch(Participant partc1,Participant partc2){
        if(partc1.equals(partc2)){
            return null;
        }
        return this.getEpreuve().getSport().methodeCalculeVainqueur(partc1,partc2,this.getEpreuve());
    }

    /**
     * @param participant le participant pour qui on calculer le temps de performance
     * @return renvoie le temps du participant à l'épreuve de cette compétition
     */
    public double fairTemps(Participant participant){
        if (participant instanceof Equipe){
            Equipe eqp = (Equipe) participant;
            return this.getEpreuve().getSport().methodeCalculePerf(this.getEpreuve().calculeResultatEquipe(eqp));
        }
        if (participant instanceof Athlete){
            Athlete ath = (Athlete) participant;
            return this.getEpreuve().getSport().methodeCalculePerf(this.getEpreuve().calculeResultat(ath));
        }
        return 0;
    }

    /**
     * @param placement liste de participants triée à la suite d'une compétition à qui l'ont va attribuer des médailles
     */
    public void AttribuerMedaille(List<Participant> placement){
        List<String> medailles= Arrays.asList("Or", "Argent", "Bronze");
        if(placement.get(0) instanceof Equipe){
            for(int i = 0; i<3 ; i++){
                Equipe equipe = (Equipe) placement.get(i);
                equipe.DonnerMedaille(medailles.get(i));
            }
        }
        else{
            for(int i = 0; i<3 ; i++){
                Athlete athlete = (Athlete) placement.get(i);
                athlete.gagne(medailles.get(i));
            }
        }
    }
}