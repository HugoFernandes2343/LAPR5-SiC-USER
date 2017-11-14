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
public class RoadsTest {
    
    public RoadsTest() {
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
     * Test of getDifficulty method, of class Road.
     */
    @Test
    public void testGetDifficulty() {
        System.out.println("getDifficulty");
        Road instance = new Road();
        int expResult = 0;
        int result = instance.getDifficulty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDifficulty method, of class Road.
     */
    @Test
    public void testSetDifficulty() {
        System.out.println("setDifficulty");
        int difficulty = 0;
        Road instance = new Road();
        instance.setDifficulty(difficulty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirst method, of class Road.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Road instance = new Road();
        Locale expResult = null;
        Locale result = instance.getFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirst method, of class Road.
     */
    @Test
    public void testSetFirst() {
        System.out.println("setFirst");
        Locale first = null;
        Road instance = new Road();
        instance.setFirst(first);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecond method, of class Road.
     */
    @Test
    public void testGetSecond() {
        System.out.println("getSecond");
        Road instance = new Road();
        Locale expResult = null;
        Locale result = instance.getSecond();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecond method, of class Road.
     */
    @Test
    public void testSetSecond() {
        System.out.println("setSecond");
        Locale second = null;
        Road instance = new Road();
        instance.setSecond(second);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Road.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Road instance = new Road();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Road.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Road instance = new Road();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
