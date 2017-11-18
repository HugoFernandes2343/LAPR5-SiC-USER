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
    }

    /**
     * Test of getOwner method, of class Locale.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Locale instance = new Locale("porto", 50);
        Character c = new Character("dude", 40, instance);
        instance.setOwner(c);
        Character expResult = c;
        Character result = instance.getOwner();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of setName method, of class Locale.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "porto";
        Locale instance = new Locale();
        instance.setName(n);
        String expResult = n;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOwner method, of class Locale.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        Locale instance = new Locale("porto", 50);
        Character c = new Character("dude", 40, instance);
        instance.setOwner(c);
        Character expResult = c;
        Character result = instance.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDifficulty method, of class Locale.
     */
    @Test
    public void testSetDifficulty() {
        System.out.println("setDifficulty");
        int d = 50;
        Locale instance = new Locale();
        instance.setDifficulty(d);
        int expResult = d;
        int result = instance.getDifficulty();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Locale.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Locale instance = new Locale("porto", 50);
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }
}
