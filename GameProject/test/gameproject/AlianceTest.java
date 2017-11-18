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
public class AlianceTest {

    public AlianceTest() {
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
     * Test of getPriv method, of class Aliance.
     */
    @Test
    public void testGetPriv() {
        System.out.println("getPriv");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(false, 20, 50, a, b);
        boolean expResult = false;
        boolean result = instance.getPriv();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompatibilityFactor method, of class Aliance.
     */
    @Test
    public void testGetCompatibilityFactor() {
        System.out.println("getCompatibilityFactor");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(false, 20, 50, a, b);
        float expResult = 20;
        float result = instance.getCompatibilityFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPower method, of class Aliance.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(false, 20, 50, a, b);
        float expResult = 50;
        float result = instance.getPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFirstCharacter method, of class Aliance.
     */
    @Test
    public void testGetFirstCharacter() {
        System.out.println("getFirstCharacter");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(false, 20, 50, a, b);
        Character expResult = a;
        Character result = instance.getFirstCharacter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSecondCharacter method, of class Aliance.
     */
    @Test
    public void testGetSecondCharacter() {
        System.out.println("getSecondCharacter");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(false, 20, 50, a, b);
        Character expResult = b;
        Character result = instance.getSecondCharacter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPriv method, of class Aliance.
     */
    @Test
    public void testSetPriv() {
        System.out.println("setPriv");
        boolean p = false;
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(true, 20, 50, a, b);
        instance.setPriv(p);
        boolean expResult = false;
        boolean result = instance.getPriv();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompatibilityFactor method, of class Aliance.
     */
    @Test
    public void testSetCompatibilityFactor() {
        System.out.println("setCompatibilityFactor");
        float p = 1;
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(true, 20, 50, a, b);
        instance.setCompatibilityFactor(p);
        float expResult = 1;
        float result = instance.getCompatibilityFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPower method, of class Aliance.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        float p = 1;
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(true, 20, 50, a, b);
        instance.setPower(p);
        float expResult = 1;
        float result = instance.getPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFirstCharacter method, of class Aliance.
     */
    @Test
    public void testSetFirstCharacter() {
        System.out.println("setFirstCharacter");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(true, 20, 50, new Character(), b);
        instance.setFirstCharacter(a);
        Character expResult = a;
        Character result = instance.getFirstCharacter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSecondCharacter method, of class Aliance.
     */
    @Test
    public void testSetSecondCharacter() {
        System.out.println("setSecondCharacter");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(true, 20, 50, a, new Character());
        instance.setSecondCharacter(b);
        Character expResult = b;
        Character result = instance.getSecondCharacter();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Aliance.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Aliance instance = new Aliance(true, 20, 50, a, new Character());
        Aliance instance2 = new Aliance(true, 20, 50, a, new Character());
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

}
