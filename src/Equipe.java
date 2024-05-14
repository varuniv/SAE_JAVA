import java.util.ArrayList;
import java.util.List;

public class Equipe implements Participant{

    private String nomEquipe;
    private int placement;
    private boolean participee;
    private Epreuve epreuve;
    private List<Athlete> membres;
    private  static boolean estPrete = false; 

    /**
     * @param nomEquipe  nom de l'équipe
     * @param epreuve  a une éoreuve à laquelle l'équipe participe
     * @param placement son classement dans son épreuve
     * @param participee si elle peut participer ou pas à une épreuve en fonction de son nombre d'athlètes.
     */
    public Equipe(String nomEquipe, Epreuve epreuve, int placement, boolean participee){
        this.nomEquipe = nomEquipe;
        this.epreuve = epreuve;
        this.placement = placement;
        this.participee = participee;
        this.membres = new ArrayList<>();
    }

    /**
     * @return le nom de l'equipe
     */
    public String getNomEquipe() {
        return nomEquipe;
    }

    /**
     * @param nomEquipe le nom de l'équipe
     */
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    /**
     * @param placement son classement dans son épreuve
     */
    public void setPlacement(int placement) {
        this.placement = placement;
    }

    /**
     * @return si l'equipe participe
     */
    public boolean isParticipee() {
        return participee;
    }

    /**
     * @param participee si léquipe participe
     */
    public void setParticipee(boolean participee) {
        this.participee = participee;
    }

    /**
     * @return l'epreuve
     */
    public Epreuve getEpreuve() {
        return this.epreuve;
    }

    /**
     * @param epreuve 
     */
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    /**
     * @return la liste des athletes de l'equipe
     */
    public List<Athlete> getMembres() {
        return this.membres;
    }

    /**
     * @param membres
     */
    public void setMembres(List<Athlete> membres) {
        this.membres = membres;
    }

    /**
     * @return si l'equipe a assez de membres pour participer à l'épreuve
     */
    public boolean estPrete() {
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
    
    /**
     * @param athlete
     */
    public void ajouteMembre( Athlete athlete){
        this.membres.add(athlete);
    }
    
    /**
     * @return la position dans le classement de l'équipe
     */
    public int getPlacement(){
        return this.placement;
    }
    
    @Override
    public void participer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'participer'");
    }

    
}
