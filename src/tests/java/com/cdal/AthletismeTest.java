package tests.java.com.cdal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.Modèle.*;

/**
 * AthletismeTest
 */
public class AthletismeTest {

    @BeforeEach
    public void setUp(){
        Athletisme athletisme110m = new Athletisme("Athletisme 110m", false, 1, 110);
    }

    @Test
    public void testgetDistance(){
        assertEquals(110,athletisme110m.getDistance());
    }

    @Test
    public void testmethodeCalculePerf(){
        assertEquals(1430.0000000000002,athletisme110m.methodeCalculePerf(200));
    }
    

}