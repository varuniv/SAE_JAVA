import java.util.ArrayList;
import java.util.List;

public class  Equipe  {

    private String nomEquipe;
    private int placement;
    private boolean participee;
    private Epreuve epreuve;
    private List<Athlete> membres;
    private  static boolean estPrete = false; 

    public Equipe(String nomEquipe, Epreuve epreuve, int placement, boolean participee){
        this.nomEquipe = nomEquipe;
        this.epreuve = epreuve;
        this.placement = placement;
        this.participee = participee;
        this.membres = new ArrayList<>();
    }
    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public boolean isParticipee() {
        return participee;
    }

    public void setParticipee(boolean participee) {
        this.participee = participee;
    }

    public Epreuve getEpreuve() {
        return this.epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public List<Athlete> getMembres() {
        return this.membres;
    }

    public void setMembres(List<Athlete> membres) {
        this.membres = membres;
    }

    public boolean EstPrete() {
        return estPrete;
    }

    public void setEstPrete() {
        if (membres.size()<4){
            Equipe.estPrete = false;

        }
        else{        
            Equipe.estPrete = true;
        
        }
        
    }
    
    public void ajouteMembre( Athlete athlete){
        this.membres.add(athlete);
    }
    
    public int getPlacement(){
        return this.placement;
    }
    public boolean estPrete(){
        return false;
    }

    public void equipePartcipante(){
        
    }

    
}