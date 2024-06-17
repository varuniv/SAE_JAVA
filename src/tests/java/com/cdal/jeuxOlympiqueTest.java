package tests.java.com.cdal;


import org.junit.Test;

import main.java.com.cdal.JeuxOlympique;
import main.java.com.cdal.Pays;

import static org.junit.Assert.*;

public class jeuxOlympiqueTest {

    @Test
    public void testGetPays() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Tokyo 2021");
        assertEquals(0, jeuxOlympique.getPays().size());

        Pays pays1 = new Pays("USA");
        jeuxOlympique.ajoutePays(pays1);
        assertEquals(1, jeuxOlympique.getPays().size());
        assertTrue(jeuxOlympique.getPays().contains(pays1));

        Pays pays2 = new Pays("France");
        jeuxOlympique.ajoutePays(pays2);
        assertEquals(2, jeuxOlympique.getPays().size());
        assertTrue(jeuxOlympique.getPays().contains(pays2));
    }

    @Test
    public void testGetNom() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Tokyo 2021");
        assertEquals("Tokyo 2021", jeuxOlympique.getNom());
    }

    @Test
    public void testAjoutePays() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Tokyo 2021");

        Pays pays1 = new Pays("USA");
        jeuxOlympique.ajoutePays(pays1);
        assertTrue(jeuxOlympique.getPays().contains(pays1));

        Pays pays2 = new Pays("France");
        jeuxOlympique.ajoutePays(pays2);
        assertTrue(jeuxOlympique.getPays().contains(pays2));
    }

    @Test
    public void testToString() {
        JeuxOlympique jeuxOlympique = new JeuxOlympique("Tokyo 2021");
        assertEquals("Tokyo 2021", jeuxOlympique.toString());
    }
}