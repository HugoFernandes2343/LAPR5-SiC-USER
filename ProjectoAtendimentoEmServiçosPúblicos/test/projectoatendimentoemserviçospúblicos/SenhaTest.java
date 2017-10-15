/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import projectoatendimentoemservicospublicos.Senha;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Norberto Sousa
 */
public class SenhaTest {

    public SenhaTest() {
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
     * Test of getNumeroContribuinte method, of class Senha.
     */
    @Test
    public void testGetNumeroContribuinte() {
        System.out.println("getNumeroContribuinte");
        Senha instance = new Senha(999999999, "A", 1);
        int expResult = 999999999;
        int result = instance.getNumeroContribuinte();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServico method, of class Senha.
     */
    @Test
    public void testGetServico() {
        System.out.println("getServico");
        Senha instance = new Senha(999999999, "A", 1);
        String expResult = "A";
        String result = instance.getServico();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeroOrdem method, of class Senha.
     */
    @Test
    public void testGetNumeroOrdem() {
        System.out.println("getNumeroOrdem");
        Senha instance = new Senha(999999999, "A", 1);
        int expResult = 1;
        int result = instance.getNumeroOrdem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumeroContribuinte method, of class Senha.
     */
    @Test
    public void testSetNumeroContribuinte() {
        System.out.println("setNumeroContribuinte");
        int i = 999999999;
        Senha instance = new Senha();
        instance.setNumeroContribuinte(i);
        int expResult = i;
        int result = instance.getNumeroContribuinte();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServico method, of class Senha.
     */
    @Test
    public void testSetServico() {
        System.out.println("setServico");
        String s = "A";
        Senha instance = new Senha();
        instance.setServico(s);
        String expResult = s;
        String result = instance.getServico();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumeroOrdem method, of class Senha.
     */
    @Test
    public void testSetNumeroOrdem() {
        System.out.println("setNumeroOrdem");
        int i = 1;
        Senha instance = new Senha();
        instance.setNumeroOrdem(i);
        int expResult = i;
        int result = instance.getNumeroOrdem();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Senha.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Senha s1 = new Senha(999999999, "A", 1);
        Senha s2 = new Senha(999999999, "A", 1);
        boolean expResult = true;
        boolean result = s1.equals(s2);
        assertEquals(expResult, result);
    }

}
