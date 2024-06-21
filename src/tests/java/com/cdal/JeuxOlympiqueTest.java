package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JeuxOlympiqueTest {

    private JeuxOlympique jeuxOlympique;
    private Pays pays1;
    private Pays pays2;
    private Pays pays3;

    @BeforeEach
    public void setUp() {
        jeuxOlympique = new JeuxOlympique("Jeux Olympiques d'été");

        pays1 = new Pays("France");
        pays2 = new Pays("USA");
        pays3 = new Pays("China");
    }

    @Test
    public void testAjoutePays() throws PaysDejaDansJOException {
        jeuxOlympique.ajoutePays(pays1);
        jeuxOlympique.ajoutePays(pays2);

        List<Pays> paysParticipants = jeuxOlympique.getPays();
        assertTrue(paysParticipants.contains(pays1));
        assertTrue(paysParticipants.contains(pays2));
        assertFalse(paysParticipants.contains(pays3));
    }

    @Test
    public void testAjoutePaysException() throws PaysDejaDansJOException {
        jeuxOlympique.ajoutePays(pays1);
        assertThrows(PaysDejaDansJOException.class, () -> jeuxOlympique.ajoutePays(pays1));
    }

    @Test
    public void testToString() throws PaysDejaDansJOException {
        jeuxOlympique.ajoutePays(pays1);
        jeuxOlympique.ajoutePays(pays2);
        jeuxOlympique.ajoutePays(pays3);

        String expected = "\nJeux Olympiques d'été\n" +
                "Les Pays qui participent sont : \n" +
                "France\n" +
                "USA\n" +
                "China\n";

        assertEquals(expected, jeuxOlympique.toString());
    }

    @Test
    public void testClassementPays() throws PaysDejaDansJOException {
        jeuxOlympique.ajoutePays(pays1);
        jeuxOlympique.ajoutePays(pays2);
        jeuxOlympique.ajoutePays(pays3);

        // Suppose some logic to award medals to countries

        List<Pays> classement = jeuxOlympique.classementPays();
        assertEquals(pays3, classement.get(0)); // Assuming China is ranked first
        assertEquals(pays2, classement.get(1)); // Assuming USA is ranked second
        assertEquals(pays1, classement.get(2)); // Assuming France is ranked third
    }
}
