package tests.java.com.cdal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquipeTest {

    private Equipe equipe;
    private Epreuve epreuve;
    private Sport sport;
    private Pays pays;
    private Athlete athlete1;
    private Athlete athlete2;

    @BeforeEach
    public void setUp() throws PasCollectifException, PasUnSexeException, MauvaiseEquipeException {
        sport = new Sport("Football", true);
        epreuve = new Epreuve("Match", sport, "M", 8.0, 7.0, 6.0, 1);
        pays = new Pays("France");
        equipe = new Equipe("Les Bleus", epreuve, pays, "M", 1);
        athlete1 = new Athlete("Doe", "John", "M", 15.0, 10.0, 12.0, pays, 1);
        athlete2 = new Athlete("Smith", "Jack", "M", 12.0, 9.0, 11.0, pays, 2);
        equipe.ajouteMembre(athlete1);
        equipe.ajouteMembre(athlete2);
    }

    @Test
    public void testGetId() {
        assertEquals(1, equipe.getId());
    }

    @Test
    public void testGetNomEquipe() {
        assertEquals("Les Bleus", equipe.getNomEquipe());
    }

    @Test
    public void testSetNomEquipe() {
        equipe.setNomEquipe("Les Rouges");
        assertEquals("Les Rouges", equipe.getNomEquipe());
    }

    @Test
    public void testIsParticipee() {
        assertFalse(equipe.isParticipee());
    }

    @Test
    public void testGetEpreuve() {
        assertEquals(epreuve, equipe.getEpreuve());
    }

    @Test
    public void testGetMembres() {
        List<Athlete> membres = equipe.getMembres();
        assertEquals(2, membres.size());
        assertTrue(membres.contains(athlete1));
        assertTrue(membres.contains(athlete2));
    }

    @Test
    public void testEstPrete() {
        equipe.setEstPrete();
        assertFalse(equipe.estPrete()); 
    }

    @Test
    public void testGetPays() {
        assertEquals(pays, equipe.getPays());
    }

    @Test
    public void testGetGenre() {
        assertEquals("M", equipe.getGenre());
    }

    @Test
    public void testSetId() {
        equipe.setId(2);
        assertEquals(2, equipe.getId());
    }

    @Test
    public void testAjouteMembre() throws MauvaiseEquipeException, PasCollectifException, PasUnSexeException {
        Athlete athlete3 = new Athlete("Martin", "Paul", "M", 14.0, 10.0, 13.0, pays, 3);
        equipe.ajouteMembre(athlete3);
        assertTrue(equipe.getMembres().contains(athlete3));
    }

    @Test
    public void testDonnerMedaille() {
        equipe.DonnerMedaille("Or");
        assertEquals(1, athlete1.getMedailles().get("Or").intValue());
        assertEquals(1, athlete2.getMedailles().get("Or").intValue());
    }

    @Test
    public void testParticiper() throws PasUnSexeException {
        VolleyBall volleyBall = new VolleyBall("VolleyBall", 6);
        Epreuve epr1 = new Epreuve("VolleyBall", volleyBall, "M", 3.5, 1.5, 2.5, 0);
        Competition competition = new Competition(epr1);
        assertTrue(equipe.participer(competition));
        assertTrue(equipe.isParticipee());
    }

    @Test
    public void testToString() {
        String expected = "L'équipe: Les Bleus a participé à l'épreuve :Match venant du sport : Football";
        assertEquals(expected, equipe.toString());
    }

    @Test
    public void testEquals() {
        Equipe otherEquipe = new Equipe("Les Bleus", epreuve, pays, "M", 1);
        otherEquipe.ajouteMembre(athlete1);
        otherEquipe.ajouteMembre(athlete2);
        assertEquals(equipe, otherEquipe);
    }
}



    

