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
    }

    /**
     * Test of setName method, of class Character.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "a";
        Character instance = new Character();
        instance.setName(name);
        String expResult = name;
        String result = instance.getName();
        assertEquals(expResult, result);

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
        int expResult = strength;
        int result = instance.getStrength();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartingLocale method, of class Character.
     */
    @Test
    public void testGetStartingLocale() {
        System.out.println("getStartingLocale");
        Locale test = new Locale("porto", 40);
        Character instance = new Character("dude", 50, test);
        Locale expResult = test;
        Locale result = instance.getStartingLocale();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartingLocale method, of class Character.
     */
    @Test
    public void testSetStartingLocale() {
        System.out.println("setStartingLocale");
        Locale l = new Locale("porto", 40);
        Character instance = new Character("dude", 50, new Locale());
        instance.setStartingLocale(l);
        Locale expResult = l;
        Locale result = instance.getStartingLocale();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Character.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Character instance = new Character("dude", 50, new Locale());
        Character instance2 = new Character("dude", 50, new Locale());
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

}
