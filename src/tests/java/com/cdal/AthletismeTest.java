package tests.java.com.cdal;
import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.cdal.Athletisme;

public class AthletismeTest {

    @Test
    public void testGetDistance() {
        Athletisme athletisme1 = new Athletisme("Course", false, 1, 100);
        Athletisme athletisme2 = new Athletisme("Saut en longueur", false, 1, 8);
        Athletisme athletisme3 = new Athletisme("Marathon", false, 1, 42195);

        assertEquals(100, athletisme1.getDistance());
        assertEquals("La distance du sport est incorrecte", 100, athletisme1.getDistance());
        assertTrue("La distance du sport doit être supérieure à 0", athletisme1.getDistance() > 0);

        assertEquals(8, athletisme2.getDistance());
        assertEquals("La distance du sport est incorrecte", 8, athletisme2.getDistance());
        assertTrue("La distance du sport doit être supérieure à 0", athletisme2.getDistance() > 0);

        assertEquals(42195, athletisme3.getDistance());
        assertEquals("La distance du sport est incorrecte", 42195, athletisme3.getDistance());
        assertTrue("La distance du sport doit être supérieure à 0", athletisme3.getDistance() > 0);
    }

    @Test
    public void testToStringCollectif() {
        Athletisme athletisme1 = new Athletisme("Relais", true, 4, 400);
        Athletisme athletisme2 = new Athletisme("Course", true, 8, 1000);
        Athletisme athletisme3 = new Athletisme("Lancer de javelot", true, 1, 80);

        String expected1 = "Sport : Relais, Collectif: Oui, Nombre de joueurs: 4, Distance: 400";
        assertEquals(expected1, athletisme1.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected1, athletisme1.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme1.toString());

        String expected2 = "Sport : Course, Collectif: Oui, Nombre de joueurs: 8, Distance: 1000";
        assertEquals(expected2, athletisme2.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected2, athletisme2.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme2.toString());

        String expected3 = "Sport : Lancer de javelot, Collectif: Oui, Nombre de joueurs: 1, Distance: 80";
        assertEquals(expected3, athletisme3.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected3, athletisme3.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme3.toString());
    }

    @Test
    public void testToStringIndividuel() {
        Athletisme athletisme1 = new Athletisme("Marathon", false, 1, 42195);
        Athletisme athletisme2 = new Athletisme("Saut en hauteur", false, 1, 2);
        Athletisme athletisme3 = new Athletisme("Course de 100 mètres", false, 1, 100);

        String expected1 = "Sport : Marathon, Collectif: Non, Nombre de joueurs: 1, Distance: 42195";
        assertEquals(expected1, athletisme1.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected1, athletisme1.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme1.toString());

        String expected2 = "Sport : Saut en hauteur, Collectif: Non, Nombre de joueurs: 1, Distance: 2";
        assertEquals(expected2, athletisme2.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected2, athletisme2.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme2.toString());

        String expected3 = "Sport : Course de 100 mètres, Collectif: Non, Nombre de joueurs: 1, Distance: 100";
        assertEquals(expected3, athletisme3.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected3, athletisme3.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme3.toString());
    }
}
