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
    }

    /**
     * Test of setDifficulty method, of class Road.
     */
    @Test
    public void testSetDifficulty() {
        System.out.println("setDifficulty");
        int difficulty = 50;
        Road instance = new Road();
        instance.setDifficulty(difficulty);
        int expResult = difficulty;
        int result = instance.getDifficulty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirst method, of class Road.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Locale a = new Locale("a", 50);
        Locale b = new Locale("b", 50);
        Road instance = new Road(a, b, 20);
        Locale expResult = a;
        Locale result = instance.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirst method, of class Road.
     */
    @Test
    public void testSetFirst() {
        System.out.println("setFirst");
        Locale a = new Locale("a", 50);
        Locale b = new Locale("b", 50);
        Road instance = new Road(new Locale(), new Locale(), 20);
        instance.setFirst(a);
        Locale expResult = a;
        Locale result = instance.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSecond method, of class Road.
     */
    @Test
    public void testGetSecond() {
        System.out.println("getSecond");
        Locale a = new Locale("a", 50);
        Locale b = new Locale("b", 50);
        Road instance = new Road(a, b, 20);
        Locale expResult = b;
        Locale result = instance.getSecond();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSecond method, of class Road.
     */
    @Test
    public void testSetSecond() {
        System.out.println("setSecond");
        Locale a = new Locale("a", 50);
        Locale b = new Locale("b", 50);
        Road instance = new Road(new Locale(), new Locale(), 20);
        instance.setFirst(b);
        Locale expResult = b;
        Locale result = instance.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Road.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Locale a = new Locale("a", 50);
        Locale b = new Locale("b", 50);
        Road instance = new Road(a, b, 20);
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);

    }

}
