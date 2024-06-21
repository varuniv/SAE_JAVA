package tests.java.com.cdal;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscrimeTest {

    private Escrime escrime;
    private Athlete athlete1;
    private Athlete athlete2;
    private Pays pays;
    private Epreuve epreuve;

    @BeforeEach
    public void setUp() throws PasUnSexeException {
        escrime = new Escrime("Escrime", "Épée");
        pays = new Pays("France");
        athlete1 = new Athlete("Doe", "John", "M", 15.0, 10.0, 12.0, pays, 1);
        athlete2 = new Athlete("Smith", "Jack", "M", 12.0, 9.0, 11.0, pays, 2);
        epreuve = new Epreuve("Finale Épée", escrime, "M", 8.0, 7.0, 6.0, 1);
    }

    @Test
    public void testGetEpee() {
        assertEquals("Épée", escrime.getEpee());
    }

    @Test
    public void testToString() {
        String expected = "Escrime: 0, Type de l'épée: Épée";
        assertEquals(expected, escrime.toString());
    }

    @Test
    public void testMethodeCalculeVainqueur() {
        Participant vainqueur = escrime.methodeCalculeVainqueur(athlete1, athlete2, epreuve);
        assertNotNull(vainqueur);
        assertTrue(vainqueur == athlete1 || vainqueur == athlete2);
    }

    @Test
    public void testMethodeCalculePerf() {
        double score = 100.0;
        assertEquals(score, escrime.methodeCalculePerf(score));
    }
}

    



