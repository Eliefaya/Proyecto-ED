/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectoed;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanpa
 */
public class CalculaExpresionTest {
    
    public CalculaExpresionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculaResultado method, of class CalculaExpresion.
     */
    @Test
    public void testCalculaResultado() throws Exception {
        System.out.println("calculaResultado");
        ArrayList expresionPostfija = null;
        double expResult = 0.0;
        double result = CalculaExpresion.calculaResultado(expresionPostfija);
        assertEquals(expResult, result, 0);
    }
    
}
