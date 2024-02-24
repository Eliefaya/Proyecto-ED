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
public class ConvertidorExpresionTest {
    
    public ConvertidorExpresionTest() {
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
     * Test of infijaAPostfija method, of class ConvertidorExpresion.
     */
    @Test
    public void testInfijaAPostfija() {
        System.out.println("infijaAPostfija");
        String expresionInfija = "";
        ArrayList expResult = null;
        ArrayList result = ConvertidorExpresion.infijaAPostfija(expresionInfija);
        assertEquals(expResult, result);
    }

    /**
     * Test of prioridad method, of class ConvertidorExpresion.
     */
    @Test
    public void testPrioridad() {
        System.out.println("prioridad");
        char operador = ' ';
        int expResult = -1;
        int result = ConvertidorExpresion.prioridad(operador);
        assertEquals(expResult, result);
    }
    
}
