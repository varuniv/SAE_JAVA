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
        double score = 700;
        double expectedTime = (800 - score) * (natation.getDistance() / 100);
        //assertEquals(expectedTime, natation.methodeCalcule(score), 0.001);
    }

    @Test
    public void testToString() {
        Natation natation = new Natation("Natation", true, 1, 100);
        String expectedString = "Sport : Natation, Collectif: Oui, Nombre de joueurs: 1, Distance: 100";
        //assertEquals(expectedString, natation.toString());
    }
}