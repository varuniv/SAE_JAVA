import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;


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
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, new Pays("France"), 1);
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, new Pays("USA"), 2);
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
        equipe.ajouteMembre(new Athlete("Doe", "John", "M", 80, 90, 70, new Pays("France"), 1));
        equipe.ajouteMembre(new Athlete("Smith", "Emma", "F", 70, 85, 75, new Pays("USA"), 2));
        equipe.ajouteMembre(new Athlete("Brown", "Michael", "M", 85, 95, 80, new Pays("UK"), 3));
        equipe.ajouteMembre(new Athlete("Johnson", "Sophia", "F", 75, 85, 75, new Pays("Germany"), 4));
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


    

