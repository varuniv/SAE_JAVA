package tests.java.com.cdal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.com.cdal.Modèle.*;

public class VolleyBallTest {

    @Test
    public void testMethodeCalcule() throws PasCollectifException, PasUnSexeException {
        VolleyBall volleyBall = new VolleyBall("VolleyBall", 6);
        Pays france = new Pays("France");
        Athlete a1 = new Athlete("Dupond","Jean","Homme",20,20,20, france, 1);
        Athlete a2 = new Athlete("Lima", "Romain", "Homme", 1, 1, 1, france, 2);
        Epreuve epr1 = new Epreuve("VolleyBall", volleyBall, "M", 3.5, 1.5, 2.5,0);
        Equipe eq1 = new Equipe("Bleu",epr1,null,"M",0);
        Equipe eq2 = new Equipe("Rouge",epr1,null,"M",0);
        
        try {
            eq2.ajouteMembre(a2);
            eq1.ajouteMembre(a1);
        } catch (MauvaiseEquipeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Participant gagnant = (Participant) volleyBall.methodeCalculeVainqueur(eq1, eq2, epr1);
        assertEquals(eq1, gagnant);
    }

    @Test
    public void testConstructor() {
        String nom = "VolleyBall";
        boolean collectif = true;
        int nbJoueur = 6;
        VolleyBall volleyBall = new VolleyBall(nom, nbJoueur);
        assertEquals(nom, volleyBall.getNom());
        assertEquals(collectif, volleyBall.estCollectif());
        assertEquals(nbJoueur, volleyBall.getNbJoueur());
    }    
}