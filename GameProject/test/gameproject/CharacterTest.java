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
public class CharacterTest {
    
    public CharacterTest() {
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
     * Test of getName method, of class Character.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Character instance = new Character();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Character.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Character instance = new Character();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrength method, of class Character.
     */
    @Test
    public void testGetStrength() {
        System.out.println("getStrength");
        Character instance = new Character();
        int expResult = 0;
        int result = instance.getStrength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrength method, of class Character.
     */
    @Test
    public void testSetStrength() {
        System.out.println("setStrength");
        int strength = 0;
        Character instance = new Character();
        instance.setStrength(strength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartingLocale method, of class Character.
     */
    @Test
    public void testGetStartingLocale() {
        System.out.println("getStartingLocale");
        Character instance = new Character();
        Locale expResult = null;
        Locale result = instance.getStartingLocale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartingLocale method, of class Character.
     */
    @Test
    public void testSetStartingLocale() {
        System.out.println("setStartingLocale");
        Locale l = null;
        Character instance = new Character();
        instance.setStartingLocale(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Character.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Character instance = new Character();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Character.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Character instance = new Character();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
