import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Competition{
    private List<Participant> listeParticipant;
    private Epreuve epreuve;


    public List<Participant> getListeParticipant() {
        return listeParticipant;
    }


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
        return null;
    }

    public List<Participant> ExecutionPooleEquipe(){
        List<Equipe> listr = new ArrayList<>();
        Map<Equipe,List<Equipe>> dic = new HashMap<>();
        if (!(listeParticipant.isEmpty())) {
            for (Equipe eq1 : listr) {

                for (Equipe eq2 : listr) {
                    epreuve.getSport().methodeCalculeVainqueur();
                }
                
            } 
        }
        return null ;
    }
}