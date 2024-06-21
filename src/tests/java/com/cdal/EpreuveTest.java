package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;

public class EpreuveTest {

    @BeforeEach
    public void setUp() {
        Natation brasseNatation = new Natation("Natation brasse", false, 1, 100);
        Epreuve brasseM = new Epreuve("100m brasse hommes", brasseNatation, "M", 4.1, 1.9, 1.5, 101);
        Epreuve brasseF = new Epreuve("100m brasse femmes", brasseNatation, "F",  4.1, 1.9, 1.5, 102);
        Athlete ath = new Athlete("ath",null,"M",10,10,10,1);
        Equipe eq1 = new Equipe( "nomEquipe",  brasseM,"null", "M",102);}

    @Tests
    public void testAjoutAthlete(){
        brasseM.ajouteAthlete(ath);
        assertTrue(brasseM.getAthletes().contains(ath));
    }
    @Tests
    public void testajouterUneEquipe(){
        brasseM.ajouterUneEquipe(eq1);
        assertTrue(brasseM.getEquipe().contains(eq1));
    }
    
    @Test
    public void testCalculeResultatEquipe(){

    }
    
    @Test
    public void testcalculeResultat(){

    }
}

   
