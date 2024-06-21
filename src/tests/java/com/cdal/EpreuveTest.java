package tests.java.com.cdal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class EpreuveTest {

    private Epreuve epreuve;
    private Sport sport;
    private Athlete athlete1;
    private Athlete athlete2;
    private Equipe equipe;

    @BeforeEach
    public void setUp() throws PasUnSexeException {
        sport = new Sport("Athlétisme", false);
        epreuve = new Epreuve("100m", sport, "M", 10.0, 8.0, 6.0, 1);
        athlete1 = new Athlete("Doe", "John", "M", 15.0, 10.0, 12.0, new Pays("France"), 1);
        athlete2 = new Athlete("Smith", "Jane", "F", 12.0, 9.0, 11.0, new Pays("USA"), 2);
        equipe = new Equipe("Team A", List.of(athlete1, athlete2));
    }

    @Test
    public void testGetId() {
        assertEquals(1, epreuve.getId());
    }

    @Test
    public void testGetNom() {
        assertEquals("100m", epreuve.getNom());
    }

    @Test
    public void testGetCategorie() {
        assertEquals("M", epreuve.getCategorie());
    }

    @Test
    public void testEstEnEquipe() {
        assertFalse(epreuve.estEnEquipe());
    }

    @Test
    public void testGetSport() {
        assertEquals(sport, epreuve.getSport());
    }

    @Test
    public void testGetForce() {
        assertEquals(10.0, epreuve.getForce(), 0.01);
    }

    @Test
    public void testGetAgilite() {
        assertEquals(8.0, epreuve.getAgilite(), 0.01);
    }

    @Test
    public void testGetEndurance() {
        assertEquals(6.0, epreuve.getEndurance(), 0.01);
    }

    @Test
    public void testAjouteUnAthlete() {
        epreuve.ajouteUnAthlete(athlete1);
        List<Athlete> athletes = epreuve.getAthletes();
        assertEquals(1, athletes.size());
        assertEquals(athlete1, athletes.get(0));
    }

    @Test
    public void testAjouteUneEquipe() {
        epreuve.ajouteUneEquipe(equipe);
        List<Equipe> equipes = epreuve.getEquipes();
        assertEquals(1, equipes.size());
        assertEquals(equipe, equipes.get(0));
    }

    @Test
    public void testSetAthletes() {
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(athlete1);
        athletes.add(athlete2);
        epreuve.setAthletes(athletes);
        assertEquals(2, epreuve.getAthletes().size());
    }

    @Test
    public void testSetEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        epreuve.setEquipes(equipes);
        assertEquals(1, epreuve.getEquipes().size());
    }

    @Test
    public void testCalculeResultat() {
        epreuve.ajouteUnAthlete(athlete1);
        double result = epreuve.calculeResultat(athlete1);
        assertTrue(result > 0);
    }

    @Test
    public void testCalculeResultatEquipe() {
        epreuve.ajouteUneEquipe(equipe);
        double result = epreuve.calculeResultatEquipe(equipe);
        assertTrue(result > 0);
    }

    @Test
    public void testMeilleurAthlete() {
        athlete1.gagne("Or");
        athlete2.gagne("Argent");
        epreuve.ajouteUnAthlete(athlete1);
        epreuve.ajouteUnAthlete(athlete2);
        assertEquals(athlete1, epreuve.meilleurAthlete());
    }

    @Test
    public void testToString() {
        String expected = "100m venant du sport : Athlétisme";
        assertEquals(expected, epreuve.toString());
    }
}
