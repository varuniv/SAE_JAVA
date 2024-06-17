import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NatationTest {

    @Test
    public void testGetDistance() {
        Natation natation = new Natation("Natation", true, 1, 100);
        assertEquals(100, natation.getDistance());
    }

    @Test
    public void testMethodeCalcule() {
        Natation natation = new Natation("Natation", true, 1, 100);
        Pays france = new Pays("France");
        Athlete a1 = new Athlete("Dupond","Jean","Homme",20,20,20, france, 1);
        Epreuve epr1 = new Epreuve("100m brasse", natation, "M", false, 4.1, 1.9, 1.5);
        double score = epr1.calculeResultat(a1);
        double expectedTime = (800 - score) * (natation.getDistance() / 100);
        assertEquals(expectedTime, natation.methodeCalculePerf(score), 0.001);
    }

    @Test
    public void testToString() {
        Natation natation = new Natation("Natation", true, 1, 100);
        String expectedString = "Sport : Natation, Collectif: Oui, Nombre de joueurs: 1, Distance: 100";
        assertEquals(expectedString, natation.toString());
    }
}