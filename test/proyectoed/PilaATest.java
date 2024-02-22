/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectoed;

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
public class PilaATest {
    
    public PilaATest() {
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
     * Test of push method, of class PilaA.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object dato = null;
        PilaA instance = new PilaA();
        instance.push(dato);
    }

    /**
     * Test of pop method, of class PilaA.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        PilaA instance = new PilaA();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class PilaA.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PilaA instance = new PilaA();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class PilaA.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PilaA instance = new PilaA();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PilaA.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PilaA instance = new PilaA();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class PilaA.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        PilaA instance = new PilaA();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PilaA.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        PilaA instance = new PilaA();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class PilaA.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object elemento = null;
        PilaA instance = new PilaA();
        boolean expResult = false;
        boolean result = instance.contains(elemento);
        assertEquals(expResult, result);
    }
    
}
