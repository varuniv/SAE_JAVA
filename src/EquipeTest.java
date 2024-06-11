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


    @Override

    public String toString(){
        return "L'équipe:"+ this.nomEquipe+" a participé à l'épreuve :"+this.epreuve;
    }
    import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class EquipeTest {

    @Test
    public void testGetNomEquipe() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        assertEquals("Équipe 1", equipe.getNomEquipe());
        assertNotNull("Le nom de l'équipe est null", equipe.getNomEquipe());
        assertNotEquals("Le nom de l'équipe ne devrait pas être vide", "", equipe.getNomEquipe());
    }

    @Test
    public void testGetPlacement() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        assertEquals(1, equipe.getPlacement());
        assertTrue(equipe.getPlacement() > 0);
        assertFalse(equipe.getPlacement() < 0);
        assertNotNull("Le placement de l'équipe est null", equipe.getPlacement());
    }

    @Test
    public void testIsParticipee() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        assertTrue(equipe.isParticipee());
        assertEquals(true, equipe.isParticipee());
        assertNotNull("L'indicateur de participation de l'équipe est null", equipe.isParticipee());
        assertNotEquals("L'indicateur de participation de l'équipe ne devrait pas être vide", "", equipe.isParticipee());
    }

    @Test
    public void testGetEpreuve() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        assertEquals(epreuve, equipe.getEpreuve());
        assertNotNull("L'épreuve de l'équipe est null", equipe.getEpreuve());
    }

    @Test
    public void testGetMembres() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        equipe.ajouteMembre(athlete1);
        equipe.ajouteMembre(athlete2);
        List<Athlete> membres = equipe.getMembres();
        assertEquals(2, membres.size());
        assertTrue(membres.contains(athlete1));
        assertTrue(membres.contains(athlete2));
        assertNotNull("La liste des membres de l'équipe est null", membres);
        assertFalse("La liste des membres de l'équipe ne devrait pas être vide", membres.isEmpty());
    }

    @Test
    public void testEstPrete() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        equipe.ajouteMembre(new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France")));
        equipe.ajouteMembre(new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA")));
        equipe.ajouteMembre(new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK")));
        equipe.ajouteMembre(new Athlete("Johnson", "Sophia", "F", 75, 85, 75, 4, new Pays("Germany")));
        equipe.setEstPrete();
        assertTrue("L'équipe devrait être prête", equipe.estPrete());
        assertEquals("L'équipe devrait être prête", true, equipe.estPrete());
    }

    @Test
    public void testToString() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1", epreuve, 1, true);
        String expected = "L'équipe:Équipe 1 a participé à l'épreuve :Relais 4x100mvenant du sport : Sport : Athletisme, Collectif: Oui, Nombre de joueurs: 4, Distance: 400";
        assertEquals(expected, equipe.toString());
        assertEquals("La représentation en chaîne de l'équipe est incorrecte", expected, equipe.toString());
        assertNotNull("La représentation en chaîne de l'équipe est null", equipe.toString());
        assertNotEquals("La représentation en chaîne de l'équipe ne doit pas être vide", "", equipe.toString());
    }
}


    
}
