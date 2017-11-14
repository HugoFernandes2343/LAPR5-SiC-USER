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
        Aliance instance = new Aliance();
        boolean expResult = false;
        boolean result = instance.getPriv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompatibilityFactor method, of class Aliance.
     */
    @Test
    public void testGetCompatibilityFactor() {
        System.out.println("getCompatibilityFactor");
        Aliance instance = new Aliance();
        float expResult = 0.0F;
        float result = instance.getCompatibilityFactor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPower method, of class Aliance.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        Aliance instance = new Aliance();
        float expResult = 0.0F;
        float result = instance.getPower();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstCharacter method, of class Aliance.
     */
    @Test
    public void testGetFirstCharacter() {
        System.out.println("getFirstCharacter");
        Aliance instance = new Aliance();
        Character expResult = null;
        Character result = instance.getFirstCharacter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondCharacter method, of class Aliance.
     */
    @Test
    public void testGetSecondCharacter() {
        System.out.println("getSecondCharacter");
        Aliance instance = new Aliance();
        Character expResult = null;
        Character result = instance.getSecondCharacter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriv method, of class Aliance.
     */
    @Test
    public void testSetPriv() {
        System.out.println("setPriv");
        boolean p = false;
        Aliance instance = new Aliance();
        instance.setPriv(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompatibilityFactor method, of class Aliance.
     */
    @Test
    public void testSetCompatibilityFactor() {
        System.out.println("setCompatibilityFactor");
        float cf = 0.0F;
        Aliance instance = new Aliance();
        instance.setCompatibilityFactor(cf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPower method, of class Aliance.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        float p = 0.0F;
        Aliance instance = new Aliance();
        instance.setPower(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstCharacter method, of class Aliance.
     */
    @Test
    public void testSetFirstCharacter() {
        System.out.println("setFirstCharacter");
        Character f = null;
        Aliance instance = new Aliance();
        instance.setFirstCharacter(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecondCharacter method, of class Aliance.
     */
    @Test
    public void testSetSecondCharacter() {
        System.out.println("setSecondCharacter");
        Character s = null;
        Aliance instance = new Aliance();
        instance.setSecondCharacter(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Aliance.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Aliance instance = new Aliance();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Aliance.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Aliance instance = new Aliance();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
