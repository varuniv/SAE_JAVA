package tests.java.com.cdal;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.cdal.Modèle.*;


public class EquipeTest {

    @Test
    public void testGetNomEquipe() throws PasCollectifException, PasUnSexeException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", 0.3, 0.3, 0.4,0);
        Equipe equipe = new Equipe("Équipe 1", epreuve,null, "M",0);
        assertEquals("Équipe 1", equipe.getNomEquipe());
        assertNotNull("Le nom de l'équipe est null", equipe.getNomEquipe());
        assertNotEquals("Le nom de l'équipe ne devrait pas être vide", "", equipe.getNomEquipe());
    }

    

    @Test
    public void testIsParticipee() throws PasUnSexeException, PasCollectifException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", 0.3, 0.3, 0.4,0);
        Equipe equipe = new Equipe("Équipe 1", epreuve,null,"M",0);
        assertTrue(equipe.isParticipee());
        assertEquals(true, equipe.isParticipee());
        assertNotNull("L'indicateur de participation de l'équipe est null", equipe.isParticipee());
        assertNotEquals("L'indicateur de participation de l'équipe ne devrait pas être vide", "", equipe.isParticipee());
    }

    @Test
    public void testGetEpreuve() throws PasUnSexeException, PasCollectifException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", 0.3, 0.3, 0.4,0);
        Equipe equipe = new Equipe("Équipe 1", epreuve,null,"M",0);
        assertEquals(epreuve, equipe.getEpreuve());
        assertNotNull("L'épreuve de l'équipe est null", equipe.getEpreuve());
    }

    @Test
    public void testGetMembres() throws PasUnSexeException, PasCollectifException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", 0.3, 0.3, 0.4,0);
        Equipe equipe = new Equipe("Équipe 1", epreuve,null,"M",0);
        Athlete athlete1 = new Athlete("Doe", "John", "M", 80, 90, 70, new Pays("France"), 1);
        Athlete athlete2 = new Athlete("Smith", "Emma", "M", 70, 85, 75, new Pays("USA"), 2);
        try {
            equipe.ajouteMembre(athlete1);
            equipe.ajouteMembre(athlete2);
        } catch (MauvaiseEquipeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        List<Athlete> membres = equipe.getMembres();
        assertEquals(2, membres.size());
        assertTrue(membres.contains(athlete1));
        assertTrue(membres.contains(athlete2));
        assertNotNull("La liste des membres de l'équipe est null", membres);
        assertFalse("La liste des membres de l'équipe ne devrait pas être vide", membres.isEmpty());
    }

    @Test
    public void testEstPrete() throws PasUnSexeException, PasCollectifException {
        Epreuve epreuve = new Epreuve("Relais 4x100m", new Athletisme("Athletisme", true, 4, 400), "Relais", 0.3, 0.3, 0.4,0);
        Equipe equipe = new Equipe("Équipe 1", epreuve,null,"M",0);
        try {
            equipe.ajouteMembre(new Athlete("Doe", "John", "M", 80, 90, 70, new Pays("France"), 1));
            equipe.ajouteMembre(new Athlete("Smith", "Emma", "M", 70, 85, 75, new Pays("USA"), 2));
            equipe.ajouteMembre(new Athlete("Brown", "Michael", "M", 85, 95, 80, new Pays("UK"), 3));
            equipe.ajouteMembre(new Athlete("Johnson", "Sophia", "M", 75, 85, 75, new Pays("Germany"), 4));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        equipe.setEstPrete();
        assertTrue("L'équipe devrait être prête", equipe.estPrete());
        assertEquals("L'équipe devrait être prête", true, equipe.estPrete());
    }

    
}


    

