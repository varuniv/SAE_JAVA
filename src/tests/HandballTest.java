import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

public class HandballTest {

    @Test
    public void testMethodeCalcule() {
        Handball handball = new Handball("Handball", true, 7);
        //List<Integer> points = handball.methodeCalculeVainqueur();
        //int pointA = points.get(0);
        //int pointB = points.get(1);
        //assertTrue(pointA >= 0);
        // assertTrue(pointB >= 0);
        // assertTrue(pointA + pointB <= 50);
    }
    
    @Test
    public void testConstructor() {
        // Handball handball = new Handball("Handball", true, 7);
        // assertEquals("Handball", handball.getNom());
        // assertTrue(handball.estCollectif());
        // assertEquals(7, handball.getNbJoueur());
    }
}