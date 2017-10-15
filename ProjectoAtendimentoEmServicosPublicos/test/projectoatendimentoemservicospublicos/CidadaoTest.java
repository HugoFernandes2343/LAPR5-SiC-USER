/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemservicospublicos;

import projectoatendimentoemservicospublicos.Cidadao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class CidadaoTest {
    
    public CidadaoTest() {
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
     * Test of getNome method, of class Cidadao.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Cidadao instance = new Cidadao();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeroContribuinte method, of class Cidadao.
     */
    @Test
    public void testGetNumeroContribuinte() {
        System.out.println("getNumeroContribuinte");
        Cidadao instance = new Cidadao();
        int expResult = 0;
        int result = instance.getNumeroContribuinte();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Cidadao.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Cidadao instance = new Cidadao();
        String expResult = "@";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodigoPostal method, of class Cidadao.
     */
    @Test
    public void testGetCodigoPostal() {
        System.out.println("getCodigoPostal");
        Cidadao instance = new Cidadao();
        String expResult = "-";
        String result = instance.getCodigoPostal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeroReparticao method, of class Cidadao.
     */
    @Test
    public void testGetNumeroReparticao() {
        System.out.println("getNumeroReparticao");
        Cidadao instance = new Cidadao();
        int expResult = 0;
        int result = instance.getNumeroReparticao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Cidadao.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String n = "";
        Cidadao instance = new Cidadao();
        instance.setNome(n);
    }

    /**
     * Test of setNumeroContribuinte method, of class Cidadao.
     */
    @Test
    public void testSetNumeroContribuinte() {
        System.out.println("setNumeroContribuinte");
        int n = 0;
        Cidadao instance = new Cidadao();
        instance.setNumeroContribuinte(n);
    }

    /**
     * Test of setEmail method, of class Cidadao.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String e = "@";
        Cidadao instance = new Cidadao();
        instance.setEmail(e);
    }

    /**
     * Test of setCodigoPostal method, of class Cidadao.
     */
    @Test
    public void testSetCodigoPostal() {
        System.out.println("setCodigoPostal");
        String cod = "";
        Cidadao instance = new Cidadao();
        instance.setCodigoPostal(cod);
    }

    /**
     * Test of setNumeroReparticao method, of class Cidadao.
     */
    @Test
    public void testSetNumeroReparticao() {
        System.out.println("setNumeroReparticao");
        int nRep = 0;
        Cidadao instance = new Cidadao();
        instance.setNumeroReparticao(nRep);
    }
    
}
