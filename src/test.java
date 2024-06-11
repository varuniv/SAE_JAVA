public class test {
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
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals("John", athlete1.getPrenom());
        assertNotNull("Le prénom de l'athlète est null", athlete1.getPrenom());

        assertEquals("Emma", athlete2.getPrenom());
        assertNotNull("Le prénom de l'athlète est null", athlete2.getPrenom());

        assertEquals("Michael", athlete3.getPrenom());
        assertNotNull("Le prénom de l'athlète est null", athlete3.getPrenom());
    }

    @Test
    public void testGetSexe() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals("M", athlete1.getSexe());
        assertNotNull("Le sexe de l'athlète est null", athlete1.getSexe());

        assertEquals("F", athlete2.getSexe());
        assertNotNull("Le sexe de l'athlète est null", athlete2.getSexe());

        assertEquals("M", athlete3.getSexe());
        assertNotNull("Le sexe de l'athlète est null", athlete3.getSexe());
    }

    @Test
    public void testGetForce() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals(80, athlete1.getForce(), 0.001);
        assertTrue("La force de l'athlète doit être supérieure à 0", athlete1.getForce() > 0);

        assertEquals(70, athlete2.getForce(), 0.001);
        assertTrue("La force de l'athlète doit être supérieure à 0", athlete2.getForce() > 0);

        assertEquals(85, athlete3.getForce(), 0.001);
        assertTrue("La force de l'athlète doit être supérieure à 0", athlete3.getForce() > 0);
    }

    @Test
    public void testGetAgilite() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals(90, athlete1.getAgilite(), 0.001);
        assertTrue("L'agilité de l'athlète doit être supérieure à 0", athlete1.getAgilite() > 0);

        assertEquals(85, athlete2.getAgilite(), 0.001);
        assertTrue("L'agilité de l'athlète doit être supérieure à 0", athlete2.getAgilite() > 0);

        assertEquals(95, athlete3.getAgilite(), 0.001);
        assertTrue("L'agilité de l'athlète doit être supérieure à 0", athlete3.getAgilite() > 0);
    }

    @Test
    public void testGetEndurance() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals(70, athlete1.getEndurance(), 0.001);
        assertTrue("L'endurance de l'athlète doit être supérieure à 0", athlete1.getEndurance() > 0);

        assertEquals(75, athlete2.getEndurance(), 0.001);
        assertTrue("L'endurance de l'athlète doit être supérieure à 0", athlete2.getEndurance() > 0);

        assertEquals(80, athlete3.getEndurance(), 0.001);
        assertTrue("L'endurance de l'athlète doit être supérieure à 0", athlete3.getEndurance() > 0);
    }

    @Test
    public void testGetParticipeACompetition() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertFalse("L'athlète devrait initialement ne pas participer à la compétition", athlete1.getParticipeACompetition());
        assertNotNull("L'état de participation de l'athlète est null", athlete1.getParticipeACompetition());

        assertFalse("L'athlète devrait initialement ne pas participer à la compétition", athlete2.getParticipeACompetition());
        assertNotNull("L'état de participation de l'athlète est null", athlete2.getParticipeACompetition());

        assertFalse("L'athlète devrait initialement ne pas participer à la compétition", athlete3.getParticipeACompetition());
        assertNotNull("L'état de participation de l'athlète est null", athlete3.getParticipeACompetition());
    }

    @Test
    public void testGetPlacement() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals(1, athlete1.getPlacement());
        assertTrue("Le placement de l'athlète doit être supérieur à 0", athlete1.getPlacement() > 0);

        assertEquals(2, athlete2.getPlacement());
        assertTrue("Le placement de l'athlète doit être supérieur à 0", athlete2.getPlacement() > 0);

        assertEquals(3, athlete3.getPlacement());
        assertTrue("Le placement de l'athlète doit être supérieur à 0", athlete3.getPlacement() > 0);
    }

    @Test
    public void testGetPays() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        assertEquals("France", athlete1.getPays().getNom());
        assertNotNull("Le pays de l'athlète est null", athlete1.getPays());

        assertEquals("USA", athlete2.getPays().getNom());
        assertNotNull("Le pays de l'athlète est null", athlete2.getPays());

        assertEquals("UK", athlete3.getPays().getNom());
        assertNotNull("Le pays de l'athlète est null", athlete3.getPays());
    }

    @Test
    public void testAjouteEpreuve() {
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        Epreuve epreuve = new Epreuve("Course");
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
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

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
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

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



public class AthletismeTest {

    @Test
    public void testGetDistance() {
        Athletisme athletisme1 = new Athletisme("Course", false, 1, 100);
        Athletisme athletisme2 = new Athletisme("Saut en longueur", false, 1, 8);
        Athletisme athletisme3 = new Athletisme("Marathon", false, 1, 42195);

        assertEquals(100, athletisme1.getDistance());
        assertEquals("La distance du sport est incorrecte", 100, athletisme1.getDistance());
        assertTrue("La distance du sport doit être supérieure à 0", athletisme1.getDistance() > 0);

        assertEquals(8, athletisme2.getDistance());
        assertEquals("La distance du sport est incorrecte", 8, athletisme2.getDistance());
        assertTrue("La distance du sport doit être supérieure à 0", athletisme2.getDistance() > 0);

        assertEquals(42195, athletisme3.getDistance());
        assertEquals("La distance du sport est incorrecte", 42195, athletisme3.getDistance());
        assertTrue("La distance du sport doit être supérieure à 0", athletisme3.getDistance() > 0);
    }

    @Test
    public void testToStringCollectif() {
        Athletisme athletisme1 = new Athletisme("Relais", true, 4, 400);
        Athletisme athletisme2 = new Athletisme("Course", true, 8, 1000);
        Athletisme athletisme3 = new Athletisme("Lancer de javelot", true, 1, 80);

        String expected1 = "Sport : Relais, Collectif: Oui, Nombre de joueurs: 4, Distance: 400";
        assertEquals(expected1, athletisme1.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected1, athletisme1.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme1.toString());

        String expected2 = "Sport : Course, Collectif: Oui, Nombre de joueurs: 8, Distance: 1000";
        assertEquals(expected2, athletisme2.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected2, athletisme2.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme2.toString());

        String expected3 = "Sport : Lancer de javelot, Collectif: Oui, Nombre de joueurs: 1, Distance: 80";
        assertEquals(expected3, athletisme3.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected3, athletisme3.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme3.toString());
    }

    @Test
    public void testToStringIndividuel() {
        Athletisme athletisme1 = new Athletisme("Marathon", false, 1, 42195);
        Athletisme athletisme2 = new Athletisme("Saut en hauteur", false, 1, 2);
        Athletisme athletisme3 = new Athletisme("Course de 100 mètres", false, 1, 100);

        String expected1 = "Sport : Marathon, Collectif: Non, Nombre de joueurs: 1, Distance: 42195";
        assertEquals(expected1, athletisme1.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected1, athletisme1.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme1.toString());

        String expected2 = "Sport : Saut en hauteur, Collectif: Non, Nombre de joueurs: 1, Distance: 2";
        assertEquals(expected2, athletisme2.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected2, athletisme2.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme2.toString());

        String expected3 = "Sport : Course de 100 mètres, Collectif: Non, Nombre de joueurs: 1, Distance: 100";
        assertEquals(expected3, athletisme3.toString());
        assertEquals("La représentation en chaîne du sport est incorrecte", expected3, athletisme3.toString());
        assertNotNull("La représentation en chaîne du sport est null", athletisme3.toString());
    }
}



public class EpreuveTest {

    @Test
    public void testAjouteUnAthlete() {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", false, 0.3, 0.3, 0.4);
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));

        epreuve.ajouteUnAthlete(athlete1);
        List<Athlete> athletes1 = epreuve.getAthletes();
        assertEquals(1, athletes1.size());
        assertTrue(athletes1.contains(athlete1));
        assertNotNull("La liste des athlètes de l'épreuve est null", athletes1);

        epreuve.ajouteUnAthlete(athlete2);
        List<Athlete> athletes2 = epreuve.getAthletes();
        assertEquals(2, athletes2.size());
        assertTrue(athletes2.contains(athlete2));
        assertNotNull("La liste des athlètes de l'épreuve est null", athletes2);

        epreuve.ajouteUnAthlete(athlete3);
        List<Athlete> athletes3 = epreuve.getAthletes();
        assertEquals(3, athletes3.size());
        assertTrue(athletes3.contains(athlete3));
        assertNotNull("La liste des athlètes de l'épreuve est null", athletes3);
    }

    @Test
    public void testAjouteUneEquipe() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", false, 1, 100), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe1 = new Equipe("Équipe 1");
        Equipe equipe2 = new Equipe("Équipe 2");
        Equipe equipe3 = new Equipe("Équipe 3");

        epreuve.ajouteUneEquipe(equipe1);
        List<Equipe> equipes1 = epreuve.getEquipes();
        assertEquals(1, equipes1.size());
        assertTrue(equipes1.contains(equipe1));
        assertNotNull("La liste des équipes de l'épreuve est null", equipes1);

        epreuve.ajouteUneEquipe(equipe2);
        List<Equipe> equipes2 = epreuve.getEquipes();
        assertEquals(2, equipes2.size());
        assertTrue(equipes2.contains(equipe2));
        assertNotNull("La liste des équipes de l'épreuve est null", equipes2);

        epreuve.ajouteUneEquipe(equipe3);
        List<Equipe> equipes3 = epreuve.getEquipes();
        assertEquals(3, equipes3.size());
        assertTrue(equipes3.contains(equipe3));
        assertNotNull("La liste des équipes de l'épreuve est null", equipes3);
    }

    @Test
    public void testGetNom() {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", false, 0.3, 0.3, 0.4);
        assertEquals("100m", epreuve.getNom());
        assertEquals("Le nom de l'épreuve est incorrect", "100m", epreuve.getNom());
        assertNotNull("Le nom de l'épreuve est null", epreuve.getNom());
        assertNotEquals("Le nom de l'épreuve ne doit pas être vide", "", epreuve.getNom());
    }

    @Test
    public void testGetCategorie() {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", false, 0.3, 0.3, 0.4);
        assertEquals("Sprint", epreuve.getCategorie());
        assertEquals("La catégorie de l'épreuve est incorrecte", "Sprint", epreuve.getCategorie());
        assertNotNull("La catégorie de l'épreuve est null", epreuve.getCategorie());
        assertNotEquals("La catégorie de l'épreuve ne doit pas être vide", "", epreuve.getCategorie());
    }

    @Test
    public void testEstEnEquipe() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", false, 1, 100), "Relais", true, 0.3, 0.3, 0.4);
        assertTrue("L'épreuve devrait être en équipe", epreuve.estEnEquipe());
        assertEquals("L'épreuve devrait être en équipe", true, epreuve.estEnEquipe());
        assertNotNull("L'état de l'épreuve est null", epreuve.estEnEquipe());
        assertNotEquals("L'épreuve ne devrait pas être individuelle", false, epreuve.estEnEquipe());
    }

    @Test
    public void testGetSport() {
        Athletisme athletisme = new Athletisme("Athletisme", false, 1, 100);
        Epreuve epreuve = new Epreuve("100m", athletisme, "Sprint", false, 0.3, 0.3, 0.4);
        assertEquals(athletisme, epreuve.getSport());
        assertNotNull("Le sport de l'épreuve est null", epreuve.getSport());
    }

    @Test
    public void testToString() {
        Athletisme athletisme = new Athletisme("Athletisme", false, 1, 100);
        Epreuve epreuve = new Epreuve("100m", athletisme, "Sprint", false, 0.3, 0.3, 0.4);
        String expected = "100mvenant du sport : Sport : Athletisme, Collectif: Non, Nombre de joueurs: 1, Distance: 100";
        assertEquals(expected, epreuve.toString());
        assertEquals("La représentation en chaîne de l'épreuve est incorrecte", expected, epreuve.toString());
        assertNotNull("La représentation en chaîne de l'épreuve est null", epreuve.toString());
        assertNotEquals("La représentation en chaîne de l'épreuve ne doit pas être vide", "", epreuve.toString());
        Athletisme athletisme2 = new Athletisme("Athletisme", false, 1, 200);
        Epreuve epreuve2 = new Epreuve("200m", athletisme2, "Sprint", false, 0.3, 0.3, 0.4);
        String expected2 = "200mvenant du sport : Sport : Athletisme, Collectif: Non, Nombre de joueurs: 1, Distance: 200";
        assertEquals(expected2, epreuve2.toString());
        assertNotNull("La représentation en chaîne de l'épreuve est null", epreuve2.toString());

        Athletisme athletisme3 = new Athletisme("Athletisme", true, 4, 400);
        Epreuve epreuve3 = new Epreuve("Relais 4x100m", athletisme3, "Relais", true, 0.3, 0.3, 0.4);
        String expected3 = "Relais 4x100mvenant du sport : Sport : Athletisme, Collectif: Oui, Nombre de joueurs: 4, Distance: 400";
        assertEquals(expected3, epreuve3.toString());
        assertNotNull("La représentation en chaîne de l'épreuve est null", epreuve3.toString());
    }

    @Test
    public void testCalculeResultat() {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", false, 0.3, 0.3, 0.4);
        Athlete athlete = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        double expectedResult = 80 * 0.3 + 90 * 0.4 + 70 * 0.3;
        double result = epreuve.calculeResultat(athlete);
        assertEquals(expectedResult, result, 0.001);
        assertEquals("Le résultat calculé de l'athlète est incorrect", expectedResult, result, 0.001);
        assertTrue("Le résultat calculé de l'athlète doit être positif", result >= 0);
        assertNotNull("Le résultat calculé de l'athlète est null", result);
    }

    @Test
    public void testCalculeResultatEquipe() {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", true, 0.3, 0.3, 0.4);
        Equipe equipe = new Equipe("Équipe 1");
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, 1, new Pays("France"));
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75, 2, new Pays("USA"));
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80, 3, new Pays("UK"));
        Athlete athlete4 = new Athlete("Johnson", "Sophia", "F", 75, 85, 75, 4, new Pays("Germany"));
        equipe.ajouteMembre(athlete1);
        equipe.ajouteMembre(athlete2);
        equipe.ajouteMembre(athlete3);
        equipe.ajouteMembre(athlete4);

        double expectedResult = (80 * 0.3 + 90 * 0.4 + 70 * 0.3) + (70 * 0.3 + 85 * 0.4 + 75 * 0.3) + (85 * 0.3 + 95 * 0.4 + 80 * 0.3) + (75 * 0.3 + 85 * 0.4 + 75 * 0.3);
        double result = epreuve.calculeResultatEquipe(equipe);
        assertEquals(expectedResult, result, 0.001);
        assertEquals("Le résultat calculé de l'équipe est incorrect", expectedResult, result, 0.001);
        assertTrue("Le résultat calculé de l'équipe doit être positif", result >= 0);
        assertNotNull("Le résultat calculé de l'équipe est null", result);
    }
}





public class JeuxOlympiqueTest {

    @Test
    public void testGetPays() {
        JeuxOlympique jo = new JeuxOlympique("JO 2024");
        Pays pays1 = new Pays("France");
        Pays pays2 = new Pays("USA");
        jo.ajoutePays(pays1);
        jo.ajoutePays(pays2);

        List<Pays> pays = jo.getPays();
        assertEquals(2, pays.size());
        assertTrue(pays.contains(pays1));
        assertTrue(pays.contains(pays2));
        assertNotNull("La liste des pays participants aux JO est null", pays);
        assertFalse("La liste des pays participants aux JO ne doit pas être vide", pays.isEmpty());
    }

    @Test
    public void testGetNom() {
        JeuxOlympique jo = new JeuxOlympique("JO 2024");
        assertEquals("JO 2024", jo.getNom());
        assertEquals("Le nom des JO est incorrect", "JO 2024", jo.getNom());
        assertNotNull("Le nom des JO est null", jo.getNom());
        assertNotEquals("Le nom des JO ne devrait pas être vide", "", jo.getNom());
    }

    @Test
    public void testAjoutePays() {
        JeuxOlympique jo = new JeuxOlympique("JO 2024");
        Pays pays1 = new Pays("France");
        Pays pays2 = new Pays("USA");
        jo.ajoutePays(pays1);
        jo.ajoutePays(pays2);

        List<Pays> pays = jo.getPays();
        assertEquals(2, pays.size());
        assertTrue(pays.contains(pays1));
        assertTrue(pays.contains(pays2));
        assertNotNull("La liste des pays participants aux JO est null", pays);
        assertFalse("La liste des pays participants aux JO ne doit pas être vide", pays.isEmpty());
    }

    @Test
    public void testToString() {
        JeuxOlympique jo = new JeuxOlympique("JO 2024");
        assertEquals("JO 2024", jo.toString());
        assertEquals("La représentation en chaîne des JO est incorrecte", "JO 2024", jo.toString());
        assertNotNull("La représentation en chaîne des JO est null", jo.toString());
        assertNotEquals("La représentation en chaîne des JO ne doit pas être vide", "", jo.toString());
    }
}


public class NatationTest {

    @Test
    public void testGetDistance() {
        Natation natation = new Natation("Natation", false, 1, 100);
        assertEquals(100, natation.getDistance());
        assertEquals("La distance de natation est incorrecte", 100, natation.getDistance());
        assertTrue("La distance de natation doit être supérieure à 0", natation.getDistance() > 0);
        assertFalse("La distance de natation ne doit pas être négative", natation.getDistance() < 0);
    }

    @Test
    public void testToString() {
        Natation natation = new Natation("Natation", true, 4, 200);
        String expected = "Sport : Natation, Collectif: Oui, Nombre de joueurs: 4, Distance: 200";
        assertEquals(expected, natation.toString());
        assertEquals("La représentation en chaîne de la natation est incorrecte", expected, natation.toString());
        assertNotNull("La représentation en chaîne de la natation est null", natation.toString());
        assertNotEquals("La représentation en chaîne de la natation ne doit pas être vide", "", natation.toString());
    }
}



   


    
}
