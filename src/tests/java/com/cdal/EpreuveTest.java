package tests.java.com.cdal;
import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.cdal.Modèle.*;


import java.util.List;

public class EpreuveTest {

    @Test
    public void testAjouteUnAthlete() throws PasUnSexeException {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", 0.3, 0.3, 0.4,0);
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70,  new Pays("France"),1);
        Athlete athlete2 = new Athlete("Smith", "Emma", "F", 70, 85, 75,  new Pays("USA"),2);
        Athlete athlete3 = new Athlete("Brown", "Michael", "M", 85, 95, 80,  new Pays("UK"),3);

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
    public void testAjouteUneEquipe() throws PasCollectifException, PasUnSexeException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", false, 1, 100), "Relais", 0.3, 0.3, 0.4,0);
        Equipe equipe1 = new Equipe("Équipe 1",epreuve,null,"M",0);
        Equipe equipe2 = new Equipe("Équipe 2",epreuve,null,"M",0);
        Equipe equipe3 = new Equipe("Équipe 3",epreuve,null,"M",0);

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
    public void testGetNom() throws PasUnSexeException {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", 0.3, 0.3, 0.4,0);
        assertEquals("100m", epreuve.getNom());
        assertEquals("Le nom de l'épreuve est incorrect", "100m", epreuve.getNom());
        assertNotNull("Le nom de l'épreuve est null", epreuve.getNom());
        assertNotEquals("Le nom de l'épreuve ne doit pas être vide", "", epreuve.getNom());
    }

    @Test
    public void testGetCategorie() throws PasUnSexeException {
        Epreuve epreuve = new Epreuve("100m", new Athletisme("Athletisme", false, 1, 100), "Sprint", 0.3, 0.3, 0.4,0);
        assertEquals("Sprint", epreuve.getCategorie());
        assertEquals("La catégorie de l'épreuve est incorrecte", "Sprint", epreuve.getCategorie());
        assertNotNull("La catégorie de l'épreuve est null", epreuve.getCategorie());
        assertNotEquals("La catégorie de l'épreuve ne doit pas être vide", "", epreuve.getCategorie());
    }

    @Test
    public void testEstEnEquipe() throws PasUnSexeException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", false, 1, 100), "Relais", 0.3, 0.3, 0.4,0);
        assertTrue("L'épreuve devrait être en équipe", epreuve.estEnEquipe());
        assertEquals("L'épreuve devrait être en équipe", true, epreuve.estEnEquipe());
        assertNotNull("L'état de l'épreuve est null", epreuve.estEnEquipe());
        assertNotEquals("L'épreuve ne devrait pas être individuelle", false, epreuve.estEnEquipe());
    }

    @Test
    public void testGetSport() throws PasUnSexeException {
        Athletisme athletisme = new Athletisme("Athletisme", false, 1, 100);
        Epreuve epreuve = new Epreuve("100m", athletisme, "Sprint", 0.3, 0.3, 0.4,0);
        assertEquals(athletisme, epreuve.getSport());
        assertNotNull("Le sport de l'épreuve est null", epreuve.getSport());
    }

    
}

   
