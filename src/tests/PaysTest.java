 

import org.junit.Test;
import static org.junit.Assert.*;

public class PaysTest {

    @Test
    public void testGetNom() {
        Pays pays = new Pays("France");
        assertEquals("France", pays.getNom());
    }

    @Test
    public void testAjouteAthlete() {
        Pays pays = new Pays("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 10, 15, 20, pays, 1);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", 12, 18, 16, pays, 2);

        pays.ajouteAthlete(athlete1);
        pays.ajouteAthlete(athlete2);

        assertEquals(2, pays.getAthletes().size());
        assertTrue(pays.getAthletes().contains(athlete1));
        assertTrue(pays.getAthletes().contains(athlete2));
    }

    @Test
    public void testNbMedailleOr() {
        Pays pays = new Pays("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 10, 15, 20, pays, 1);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", 12, 18, 16, pays, 2);

        athlete1.gagne("Or");
        athlete1.gagne("Or");
        athlete2.gagne("Or");

        pays.ajouteAthlete(athlete1);
        pays.ajouteAthlete(athlete2);

        assertEquals(3, pays.nbMedailleOr());
    }

    @Test
    public void testNbMedailleArgent() {
        Pays pays = new Pays("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 10, 15, 20, pays, 1);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", 12, 18, 16, pays, 2);

        athlete1.gagne("Argent");
        athlete1.gagne("Argent");
        athlete2.gagne("Argent");

        pays.ajouteAthlete(athlete1);
        pays.ajouteAthlete(athlete2);

        assertEquals(3, pays.nbMedailleArgent());
    }

    @Test
    public void testNbMedailleBronze() {
        Pays pays = new Pays("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 10, 15, 20, pays, 1);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", 12, 18, 16, pays, 2);

        athlete1.gagne("Bronze");
        athlete1.gagne("Bronze");
        athlete2.gagne("Bronze");

        pays.ajouteAthlete(athlete1);
        pays.ajouteAthlete(athlete2);

        assertEquals(3, pays.nbMedailleBronze());
    }

    @Test
    public void testNbMedaillesTotales() {
        Pays pays = new Pays("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 10, 15, 20, pays, 1);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", 12, 18, 16, pays, 2);

        athlete1.gagne("Or");
        athlete1.gagne("Argent");
        athlete2.gagne("Bronze");

        pays.ajouteAthlete(athlete1);
        pays.ajouteAthlete(athlete2);

        assertEquals(3, pays.nbMedaillesTotales());
    }

    @Test
    public void testMeilleurAthlete() {
        Pays pays = new Pays("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 10, 15, 20, pays, 1);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", 12, 18, 16, pays, 2);

        athlete1.gagne("Or");
        athlete1.gagne("Argent");
        athlete2.gagne("Or");
        athlete2.gagne("Bronze");

        pays.ajouteAthlete(athlete1);
        pays.ajouteAthlete(athlete2);

        assertEquals(athlete1, pays.meilleurAthlete());
    }
}
