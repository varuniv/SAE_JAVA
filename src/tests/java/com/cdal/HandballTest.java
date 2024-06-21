package tests.java.com.cdal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HandballTest {

    private Handball handball;
    private Pays pays;
    private Epreuve epreuve;
    private Equipe equipeA;
    private Equipe equipeB;
    private Athlete athlete1;
    private Athlete athlete2;
    private Athlete athlete3;
    private Athlete athlete4;

    @BeforeEach
    public void setUp() throws PasUnSexeException, PasCollectifException, MauvaiseEquipeException {
        handball = new Handball("Handball", 7);
        pays = new Pays("France");
        
        athlete1 = new Athlete("Doe", "John", "M", 15.0, 10.0, 12.0, pays, 1);
        athlete2 = new Athlete("Smith", "Jack", "M", 12.0, 9.0, 11.0, pays, 2);
        athlete3 = new Athlete("Brown", "Jim", "M", 14.0, 11.0, 10.0, pays, 3);
        athlete4 = new Athlete("Taylor", "Tom", "M", 13.0, 8.0, 9.0, pays, 4);
        
        epreuve = new Epreuve("Finale", handball, "M", 8.0, 7.0, 6.0, 1);

        equipeA = new Equipe("TeamA", epreuve, pays, "M", 1);
        equipeB = new Equipe("TeamB", epreuve, pays, "M", 2);
        
        equipeA.ajouteMembre(athlete1);
        equipeA.ajouteMembre(athlete2);
        
        equipeB.ajouteMembre(athlete3);
        equipeB.ajouteMembre(athlete4);
    }

    @Test
    public void testMethodeCalculeVainqueur() {
        Participant vainqueur = handball.methodeCalculeVainqueur(equipeA, equipeB, epreuve);
        assertNotNull(vainqueur);
        assertTrue(vainqueur == equipeA || vainqueur == equipeB);
    }

    @Test
    public void testMethodeCalculePerf() {
        double score = 100.0;
        assertEquals(score, handball.methodeCalculePerf(score));
    }

    @Test
    public void testToString() {
        String expected = "Handball: 7";
        assertEquals(expected, handball.toString());
    }
}
