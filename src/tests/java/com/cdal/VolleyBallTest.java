package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;


public class VolleyBallTest {
    private Epreuve epreuveMock;

    @BeforeEach
    public void setUp() {
        // Simulation d'une épreuve (mock)
        epreuveMock = new Epreuve() {
            @Override
            public double calculeResultatEquipe(Participant equipe) {
                // Simulation de calcul de résultat
                return Math.random() * 100; // Exemple de résultat aléatoire
            }
        };
    }

    @Test
    public void testMethodeCalculeVainqueur() {
        // Création de deux participants (simulés)
        Participant equipeA = new Participant("Équipe A");
        Participant equipeB = new Participant("Équipe B");

        // Création d'une instance de VolleyBall
        VolleyBall volleyBall = new VolleyBall("Volley-ball", 6); // Exemple avec 6 joueurs par équipe

        // Appel de la méthode à tester
        Participant vainqueur = volleyBall.methodeCalculeVainqueur(equipeA, equipeB, epreuveMock);

        // Vérifications
        assertNotNull(vainqueur); // Le vainqueur ne doit pas être null
        assertTrue(vainqueur == equipeA || vainqueur == equipeB); // Le vainqueur doit être l'un des deux participants
    }

    @Test
    public void testMethodeCalculePerf() {
        // Création d'une instance de VolleyBall
        VolleyBall volleyBall = new VolleyBall("Volley-ball", 6); // Exemple avec 6 joueurs par équipe

        // Appel de la méthode à tester avec un score simulé
        double score = 10.5; // Exemple de score

        // Vérification
        assertEquals(score, volleyBall.methodeCalculePerf(score)); // La méthode doit retourner le score tel quel
    }
}
