import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class AthleteTest {

    @Test
    public void testGetNom() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals("Doe", athlete1.getNom());
        assertNotNull("Le nom de l'athlète est null", athlete1.getNom());

        assertEquals("Smith", athlete2.getNom());
        assertNotNull("Le nom de l'athlète est null", athlete2.getNom());

        assertEquals("Brown", athlete3.getNom());
        assertNotNull("Le nom de l'athlète est null", athlete3.getNom());
    }

    @Test
    public void testGetPrenom() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals("John", athlete1.getPrenom());
        assertNotNull("Le prénom de l'athlète est null", athlete1.getPrenom());

        assertEquals("Emma", athlete2.getPrenom());
        assertNotNull("Le prénom de l'athlète est null", athlete2.getPrenom());

        assertEquals("Michael", athlete3.getPrenom());
        assertNotNull("Le prénom de l'athlète est null", athlete3.getPrenom());
    }

    @Test
    public void testGetSexe() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals("M", athlete1.getSexe());
        assertNotNull("Le sexe de l'athlète est null", athlete1.getSexe());

        assertEquals("F", athlete2.getSexe());
        assertNotNull("Le sexe de l'athlète est null", athlete2.getSexe());

        assertEquals("M", athlete3.getSexe());
        assertNotNull("Le sexe de l'athlète est null", athlete3.getSexe());
    }

    @Test
    public void testGetForce() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals(80, athlete1.getForce(), 0.001);
        assertTrue("La force de l'athlète doit être supérieure à 0", athlete1.getForce() > 0);

        assertEquals(70, athlete2.getForce(), 0.001);
        assertTrue("La force de l'athlète doit être supérieure à 0", athlete2.getForce() > 0);

        assertEquals(85, athlete3.getForce(), 0.001);
        assertTrue("La force de l'athlète doit être supérieure à 0", athlete3.getForce() > 0);
    }

    @Test
    public void testGetAgilite() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals(90, athlete1.getAgilite(), 0.001);
        assertTrue("L'agilité de l'athlète doit être supérieure à 0", athlete1.getAgilite() > 0);

        assertEquals(85, athlete2.getAgilite(), 0.001);
        assertTrue("L'agilité de l'athlète doit être supérieure à 0", athlete2.getAgilite() > 0);

        assertEquals(95, athlete3.getAgilite(), 0.001);
        assertTrue("L'agilité de l'athlète doit être supérieure à 0", athlete3.getAgilite() > 0);
    }

    @Test
    public void testGetEndurance() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals(70, athlete1.getEndurance(), 0.001);
        assertTrue("L'endurance de l'athlète doit être supérieure à 0", athlete1.getEndurance() > 0);

        assertEquals(75, athlete2.getEndurance(), 0.001);
        assertTrue("L'endurance de l'athlète doit être supérieure à 0", athlete2.getEndurance() > 0);

        assertEquals(80, athlete3.getEndurance(), 0.001);
        assertTrue("L'endurance de l'athlète doit être supérieure à 0", athlete3.getEndurance() > 0);
    }

    @Test
    public void testGetParticipeACompetition() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, new Pays("UK"));

        assertFalse("L'athlète devrait initialement ne pas participer à la compétition", athlete1.getParticipeACompetition());
        assertNotNull("L'état de participation de l'athlète est null", athlete1.getParticipeACompetition());

        assertFalse("L'athlète devrait initialement ne pas participer à la compétition", athlete2.getParticipeACompetition());
        assertNotNull("L'état de participation de l'athlète est null", athlete2.getParticipeACompetition());

        assertFalse("L'athlète devrait initialement ne pas participer à la compétition", athlete3.getParticipeACompetition());
        assertNotNull("L'état de participation de l'athlète est null", athlete3.getParticipeACompetition());
    }

    @Test
    public void testGetPlacement() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals(1, athlete1.getPlacement());
        assertTrue("Le placement de l'athlète doit être supérieur à 0", athlete1.getPlacement() > 0);

        assertEquals(2, athlete2.getPlacement());
        assertTrue("Le placement de l'athlète doit être supérieur à 0", athlete2.getPlacement() > 0);

        assertEquals(3, athlete3.getPlacement());
        assertTrue("Le placement de l'athlète doit être supérieur à 0", athlete3.getPlacement() > 0);
    }

    @Test
    public void testGetPays() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        assertEquals("France", athlete1.getPays().getNom());
        assertNotNull("Le pays de l'athlète est null", athlete1.getPays());

        assertEquals("USA", athlete2.getPays().getNom());
        assertNotNull("Le pays de l'athlète est null", athlete2.getPays());

        assertEquals("UK", athlete3.getPays().getNom());
        assertNotNull("Le pays de l'athlète est null", athlete3.getPays());
    }

    @Test
    public void testAjouteEpreuve() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        Epreuve epreuve = new Epreuve("Course",new Athletisme("a", false, 1, 100),"M", false,);
        athlete1.ajouteEpreuve(epreuve);
        List<Epreuve> epreuves1 = athlete1.getEpreuves();
        assertEquals(1, epreuves1.size());
        assertNotNull("La liste des épreuves de l'athlète est null", epreuves1);

        athlete2.ajouteEpreuve(epreuve);
        List<Epreuve> epreuves2 = athlete2.getEpreuves();
        assertEquals(1, epreuves2.size());
        assertNotNull("La liste des épreuves de l'athlète est null", epreuves2);

        athlete3.ajouteEpreuve(epreuve);
        List<Epreuve> epreuves3 = athlete3.getEpreuves();
        assertEquals(1, epreuves3.size());
        assertNotNull("La liste des épreuves de l'athlète est null", epreuves3);
    }

    @Test
    public void testGagne() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        athlete1.gagne("Or");
        athlete1.gagne("Argent");
        athlete1.gagne("Bronze");
        Map<String,Integer> medailles1 = athlete1.getMedailles();
        assertEquals(1, (int)medailles1.get("Or"));
        assertNotNull("La liste des médailles de l'athlète est null", medailles1);

        athlete2.gagne("Or");
        athlete2.gagne("Argent");
        athlete2.gagne("Bronze");
        Map<String,Integer> medailles2 = athlete2.getMedailles();
        assertEquals(1, (int)medailles2.get("Or"));
        assertNotNull("La liste des médailles de l'athlète est null", medailles2);

        athlete3.gagne("Or");
        athlete3.gagne("Argent");
        athlete3.gagne("Bronze");
        Map<String,Integer> medailles3 = athlete3.getMedailles();
        assertEquals(1, (int)medailles3.get("Or"));
        assertNotNull("La liste des médailles de l'athlète est null", medailles3);
    }

    @Test
    public void testToString() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"));

        athlete1.gagne("Or");
        athlete1.gagne("Argent");
        athlete1.gagne("Bronze");
        String expected1 = "Doe John: [Doe John a une force de 80.0, une agilité de 90.0 et une endurance de 70.0. Il vient de France. Dans le classement il est 1 et a 1 médailles d'or, 1 médailles d'argent et 1 médailles de bronze]";
        assertEquals(expected1, athlete1.toString());
        assertNotNull("La représentation en chaîne de l'athlète est null", athlete1.toString());

        athlete2.gagne("Or");
        athlete2.gagne("Argent");
        athlete2.gagne("Bronze");
        String expected2 = "Smith Emma: [Smith Emma a une force de 70.0, une agilité de 85.0 et une endurance de 75.0. Elle vient de USA. Dans le classement elle est 2 et a 1 médailles d'or, 1 médailles d'argent et 1 médailles de bronze]";
        assertEquals(expected2, athlete2.toString());
        assertNotNull("La représentation en chaîne de l'athlète est null", athlete2.toString());

        athlete3.gagne("Or");
        athlete3.gagne("Argent");
        athlete3.gagne("Bronze");
        String expected3 = "Brown Michael: [Brown Michael a une force de 85.0, une agilité de 95.0 et une endurance de 80.0. Il vient de UK. Dans le classement il est 3 et a 1 médailles d'or, 1 médailles d'argent et 1 médailles de bronze]";
        assertEquals(expected3, athlete3.toString());
        assertNotNull("La représentation en chaîne de l'athlète est null", athlete3.toString());
    }
}


