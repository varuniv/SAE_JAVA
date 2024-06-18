package tests.java.com.cdal;


import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.cdal.Modèle.Escrime;

public class EscrimeTest {

    @Test
    public void testGetEpee() {
        Escrime escrime = new Escrime("Escrime", "Foil");
        assertEquals("Foil", escrime.getEpee());
        assertNotNull("Le type d'épée de l'escrime est null", escrime.getEpee());
        assertNotEquals("Le type d'épée de l'escrime ne devrait pas être vide", "", escrime.getEpee());
    }

    
}


