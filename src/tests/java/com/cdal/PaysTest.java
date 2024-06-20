package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;
 


import main.java.com.cdal.Modèle.*;



public class PaysTest {
    @BeforeEach
    public void setUp(){
        Pays france = new Pays("France");
        Pays mongolie = new Pays("Mngolie");
        Pays pologne = new Pays("Pologne");
        Pays groenland = new Pays("Groenland");
        Pays chine = new Pays("Chine");
        Pays russie = new Pays("Russie");
        Pays japon = new Pays("Japon");
        
        JO.ajoutePays(france);
        JO.ajoutePays(mongolie);
        JO.ajoutePays(pologne);
        JO.ajoutePays(groenland);
        JO.ajoutePays(chine);
        JO.ajoutePays(russie);
        JO.ajoutePays(japon);
    }

   
}
