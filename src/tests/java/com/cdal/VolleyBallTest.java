package tests.java.com.cdal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Equipe;
import main.java.com.cdal.MauvaiseEquipeException;
import main.java.com.cdal.Pays;
import main.java.com.cdal.VolleyBall;


public class VolleyBallTest {

    @Test
    public void testMethodeCalcule() {
        VolleyBall volleyBall = new VolleyBall("VolleyBall", true, 6);
        Pays france = new Pays("France");
        Athlete a1 = new Athlete("Dupond","Jean","Homme",20,20,20, france, 1);
        Athlete a2 = new Athlete("Lima", "Romain", "Homme", 1, 1, 1, france, 2);
        Epreuve epr1 = new Epreuve("VolleyBall", volleyBall, "M", true, 3.5, 1.5, 2.5);
        Equipe eq1 = new Equipe("Bleu",epr1,true,null,"M");
        Equipe eq2 = new Equipe("Rouge",epr1,true,null,"M");
        
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
        VolleyBall volleyBall = new VolleyBall(nom, collectif, nbJoueur);
        assertEquals(nom, volleyBall.getNom());
        assertEquals(collectif, volleyBall.estCollectif());
        assertEquals(nbJoueur, volleyBall.getNbJoueur());
    }    
}