package tests.java.com.cdal;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;


import java.util.List;
import java.util.Map;


public class AthleteTest {

    private Athlete athlete;

    @BeforeEach
    public void setUp() throws PasUnSexeException {
        athlete = new Athlete("Doe", "John", "M", 15.0, 10.0, 12.0, new Pays("France"), 1);
    }

    @Test
    public void testGetId() {
        assertEquals(1, athlete.getId());
    }

    @Test
    public void testGetNom() {
        assertEquals("Doe", athlete.getNom());
    }

    @Test
    public void testGetParticipeACompetition() {
        assertFalse(athlete.getParticipeACompetition());
    }

    @Test
    public void testGetPays() {
        assertEquals("France", athlete.getPays().getNom());
    }

    @Test
    public void testGetPrenom() {
        assertEquals("John", athlete.getPrenom());
    }

    @Test
    public void testGetSexe() {
        assertEquals("M", athlete.getSexe());
    }

    @Test
    public void testGetForce() {
        assertEquals(15.0, athlete.getForce(), 0.01);
    }

    @Test
    public void testGetAgilite() {
        assertEquals(10.0, athlete.getAgilite(), 0.01);
    }

    @Test
    public void testGetEndurance() {
        assertEquals(12.0, athlete.getEndurance(), 0.01);
    }

    @Test
    public void testGetMedailles() {
        Map<String, Integer> medailles = athlete.getMedailles();
        assertEquals(0, medailles.get("Or").intValue());
        assertEquals(0, medailles.get("Argent").intValue());
        assertEquals(0, medailles.get("Bronze").intValue());
    }

    @Test
    public void testGetEpreuves() {
        List<Epreuve> epreuves = athlete.getEpreuves();
        assertTrue(epreuves.isEmpty());
    }

    @Test
    public void testGetPlacement() {
        assertEquals(0, athlete.getPlacement());
    }

    @Test
    public void testAjouteEpreuve() throws PasUnSexeException {
        Epreuve epreuve = new Epreuve("100m",null,null,4.1,1.9,1.5,0);
        athlete.ajouteEpreuve(epreuve);
        List<Epreuve> epreuves = athlete.getEpreuves();
        assertEquals(1, epreuves.size());
        assertEquals(epreuve, epreuves.get(0));
    }

  
    @Test
    public void testParticiper() throws PasUnSexeException {
        VolleyBall volleyBall = new VolleyBall("VolleyBall", 6);
        Epreuve epr1 = new Epreuve("VolleyBall", volleyBall, "M",  3.5, 1.5, 2.5,0);
        Competition competition = new Competition(epr1);
        assertTrue(athlete.participer(competition));
        assertTrue(athlete.getParticipeACompetition());
    }

    @Test
    public void testGagne() {
        athlete.gagne("Or");
        athlete.gagne("Argent");
        athlete.gagne("Bronze");
        Map<String, Integer> medailles = athlete.getMedailles();
        assertEquals(1, medailles.get("Or").intValue());
        assertEquals(1, medailles.get("Argent").intValue());
        assertEquals(1, medailles.get("Bronze").intValue());
    }

    @Test
    public void testToString() {
        String expected = "Doe John: [Doe John a une force de 15.0, une agilité de 10.0 et une endurance de 12.0. Il vient de France. Dans le classement il est 0 et a 0 médailles d'or, 0 médailles d'argent et 0 médailles de bronze]";
        assertEquals(expected, athlete.toString());
    }
}