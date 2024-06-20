package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;

public class EpreuveTest {
    @BeforeEach
    public void setUp(){
        Natation brasseNatation = new Natation("Natation brasse", false, 1, 100);

        Epreuve brasseM = new Epreuve("100m brasse hommes", brasseNatation, "M", 4.1, 1.9, 1.5, 101);
        Epreuve brasseF = new Epreuve("100m brasse femmes", brasseNatation, "F",  4.1, 1.9, 1.5, 102);}
    

    
}

   
