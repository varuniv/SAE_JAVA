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
     * @param epreuve  a une épreuve à laquelle l'équipe participe
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

    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.epreuve = null;
        this.placement = 0;
        this.participee = false;
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
     * @param athlete un Athlete
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
    
    /**
     * @param compet Une Competition en Equipe
     * @return Si l'équipe a été ajouté
     */
    @Override
    public boolean participer(Competition compet) {
        return compet.ajoute(this);
    }


    @Override
    public String toString(){
        return "L'équipe:"+ this.nomEquipe+" a participé à l'épreuve :"+this.epreuve;
    }
    
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
    
