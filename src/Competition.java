import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Competition{
    private List<Participant> listeParticipant;
    private Epreuve epreuve;



    public Competition(Epreuve epreuve) {
        this.listeParticipant = new ArrayList<>();
        this.epreuve = epreuve;
    }

    public Competition(List<Participant> listeParticipant, Epreuve epreuve) {
        this.listeParticipant = listeParticipant;
        this.epreuve = epreuve;
    }
    
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
    /**
     * @return le list des participents 
     */
    public List<Participant> getListeParticipant() {
        return listeParticipant;
    }

    /**
     * @return
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

    public Participant jouerMatch(Participant partc1,Participant partc2){
        if(partc1.equals(partc2)){
            return null;
        }
        return this.getEpreuve().getSport().methodeCalculeVainqueur(partc1,partc2,this.getEpreuve());
    }

    public double fairTemps(Participant prarticipant){
        if (prarticipant instanceof Equipe){
            Equipe eqp = (Equipe) prarticipant;
            return this.getEpreuve().getSport().methodeCalculePerf(this.getEpreuve().calculeResultatEquipe(eqp));
        }
        if (prarticipant instanceof Athlete){
            Athlete ath = (Athlete) prarticipant;
            return this.getEpreuve().getSport().methodeCalculePerf(this.getEpreuve().calculeResultat(ath));
        }
        return 0;
    }

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