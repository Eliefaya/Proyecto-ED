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
public class VerificaCadenaTest {
    
    public VerificaCadenaTest() {
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
     * Test of verifica method, of class VerificaCadena.
     */
    @Test
    public void testVerifica() {
        System.out.println("verifica");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verifica(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of esParentesis method, of class VerificaCadena.
     */
    @Test
    public void testEsParentesis() {
        System.out.println("esParentesis");
        char caracter = ' ';
        boolean expResult = false;
        boolean result = VerificaCadena.esParentesis(caracter);
        assertEquals(expResult, result);
    }

    /**
     * Test of esOperador method, of class VerificaCadena.
     */
    @Test
    public void testEsOperador() {
        System.out.println("esOperador");
        char caracter = ' ';
        boolean expResult = false;
        boolean result = VerificaCadena.esOperador(caracter);
        assertEquals(expResult, result);
    }

    /**
     * Test of esPunto method, of class VerificaCadena.
     */
    @Test
    public void testEsPunto() {
        System.out.println("esPunto");
        char caracter = ' ';
        boolean expResult = false;
        boolean result = VerificaCadena.esPunto(caracter);
        assertEquals(expResult, result);
    }

    /**
     * Test of esNumero method, of class VerificaCadena.
     */
    @Test
    public void testEsNumero() {
        System.out.println("esNumero");
        char caracter = ' ';
        boolean expResult = false;
        boolean result = VerificaCadena.esNumero(caracter);
        assertEquals(expResult, result);
    }

    /**
     * Test of esMasMenos method, of class VerificaCadena.
     */
    @Test
    public void testEsMasMenos() {
        System.out.println("esMasMenos");
        char caracter = ' ';
        boolean expResult = false;
        boolean result = VerificaCadena.esMasMenos(caracter);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaInicio method, of class VerificaCadena.
     */
    @Test
    public void testVerificaInicio() {
        System.out.println("verificaInicio");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaInicio(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaFinal method, of class VerificaCadena.
     */
    @Test
    public void testVerificaFinal() {
        System.out.println("verificaFinal");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaFinal(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaCaracteresAdmitidos method, of class VerificaCadena.
     */
    @Test
    public void testVerificaCaracteresAdmitidos() {
        System.out.println("verificaCaracteresAdmitidos");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaCaracteresAdmitidos(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaSeparaciones method, of class VerificaCadena.
     */
    @Test
    public void testVerificaSeparaciones() {
        System.out.println("verificaSeparaciones");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaSeparaciones(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaPuntosNumVecinos method, of class VerificaCadena.
     */
    @Test
    public void testVerificaPuntosNumVecinos() {
        System.out.println("verificaPuntosNumVecinos");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaPuntosNumVecinos(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaPuntosConteniendoNum method, of class VerificaCadena.
     */
    @Test
    public void testVerificaPuntosConteniendoNum() {
        System.out.println("verificaPuntosConteniendoNum");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaPuntosConteniendoNum(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaParentesisBalanceados method, of class VerificaCadena.
     */
    @Test
    public void testVerificaParentesisBalanceados() {
        System.out.println("verificaParentesisBalanceados");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaParentesisBalanceados(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaParentesisContenido method, of class VerificaCadena.
     */
    @Test
    public void testVerificaParentesisContenido() {
        System.out.println("verificaParentesisContenido");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaParentesisContenido(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaParentesisInicioFinal method, of class VerificaCadena.
     */
    @Test
    public void testVerificaParentesisInicioFinal() {
        System.out.println("verificaParentesisInicioFinal");
        String cadena = "";
        boolean expResult = false;
        boolean result = VerificaCadena.verificaParentesisInicioFinal(cadena);
        assertEquals(expResult, result);
    }
    
}
