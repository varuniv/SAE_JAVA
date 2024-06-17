package tests.java.com.cdal;


import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.cdal.Escrime;

public class EscrimeTest {

    @Test
    public void testGetEpee() {
        Escrime escrime = new Escrime("Escrime", true, 1, "Foil");
        assertEquals("Foil", escrime.getEpee());
        assertNotNull("Le type d'épée de l'escrime est null", escrime.getEpee());
        assertNotEquals("Le type d'épée de l'escrime ne devrait pas être vide", "", escrime.getEpee());
    }

    @Test
    public void testToString() {
        Escrime escrime = new Escrime("Escrime", true, 1, "Foil");
        String expected = "Escrime: 1, Type de l'épée: Foil";
        assertEquals(expected, escrime.toString());
        assertEquals("La représentation en chaîne de l'escrime est incorrecte", expected, escrime.toString());
        assertNotNull("La représentation en chaîne de l'escrime est null", escrime.toString());
        assertNotEquals("La représentation en chaîne de l'escrime ne doit pas être vide", "", escrime.toString());
    }
}


