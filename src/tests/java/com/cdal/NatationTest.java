package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;

import main.java.com.cdal.Modèle.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NatationTest {

    private Natation natation;

    @BeforeEach
    public void setUp() {
        natation = new Natation("Natation 100m", false, 1, 100);
    }

    @Test
    public void testGetDistance() {
        assertEquals(100, natation.getDistance());
    }

    @Test
    public void testMethodeCalculePerf() {
        // Supposons un score de performance pour un nageur
        double score = 100.0;
        double expected = (800 - score) * (natation.getDistance() / 100);
        assertEquals(expected, natation.methodeCalculePerf(score));
    }

    @Test
    public void testMethodeCalculeVainqueur() {
        Participant participantA = new Athlete("Alice", "F", new Pays("France"));
        Participant participantB = new Athlete("Bob", "M", new Pays("USA"));

        assertNull(natation.methodeCalculeVainqueur(participantA, participantB, null));
    }

    @Test
    public void testToString() {
        String expected = "Sport : Natation 100m, Collectif: Non, Nombre de joueurs: 1, Distance: 100";
        assertEquals(expected, natation.toString());
    }
}
