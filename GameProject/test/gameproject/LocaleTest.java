/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hugod
 */
public class LocaleTest {
    
    public LocaleTest() {
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
     * Test of getName method, of class Locale.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Locale instance = new Locale();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Locale.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Locale instance = new Locale();
        Character expResult = null;
        Character result = instance.getOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDifficulty method, of class Locale.
     */
    @Test
    public void testGetDifficulty() {
        System.out.println("getDifficulty");
        Locale instance = new Locale();
        int expResult = 0;
        int result = instance.getDifficulty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Locale.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "";
        Locale instance = new Locale();
        instance.setName(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwner method, of class Locale.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        Character o = null;
        Locale instance = new Locale();
        instance.setOwner(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDifficulty method, of class Locale.
     */
    @Test
    public void testSetDifficulty() {
        System.out.println("setDifficulty");
        int d = 0;
        Locale instance = new Locale();
        instance.setDifficulty(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Locale.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Locale instance = new Locale();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Locale.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Locale instance = new Locale();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
