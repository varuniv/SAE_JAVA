import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HandballTest {

    @Test
    public void testMethodeCalcule() {
        Handball handBall = new Handball("HandBall", true, 6);
        Pays france = new Pays("France");
        Athlete a1 = new Athlete("Dupond","Jean","Homme",20,20,20, france, 1);
        Athlete a2 = new Athlete("Lima", "Romain", "Homme", 1, 1, 1, france, 2);
        Epreuve epr1 = new Epreuve("VolleyBall", handBall, "M", true, 3.5, 1.5, 2.5);
        Equipe eq1 = new Equipe("Bleu");
        Equipe eq2 = new Equipe("Rouge");
        eq1.ajouteMembre(a1);
        eq2.ajouteMembre(a2);
        Participant gagnant = handBall.methodeCalculeVainqueur(eq1, eq2, epr1);
        assertEquals(eq1, gagnant);
    }

    @Test
    public void testConstructor() {
        String nom = "HandBall";
        boolean collectif = true;
        int nbJoueur = 6;
        Handball handball = new Handball(nom, collectif, nbJoueur);
        assertEquals(nom, handball.getNom());
        assertEquals(collectif, handball.estCollectif());
        assertEquals(nbJoueur, handball.getNbJoueur());
    }
}