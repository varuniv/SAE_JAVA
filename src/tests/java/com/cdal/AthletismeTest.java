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
}