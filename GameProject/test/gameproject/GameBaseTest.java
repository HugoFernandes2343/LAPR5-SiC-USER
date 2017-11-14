/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import graphMap.Graph;
import graphMatrix.AdjacencyMatrixGraph;
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
public class GameBaseTest {
    
    public GameBaseTest() {
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
     * Test of GameBase method, of class GameBase.
     */
    @Test
    public void testGameBase() {
        System.out.println("GameBase");
        GameBase instance = new GameBase();
    }

    /**
     * Test of searchForLocal method, of class GameBase.
     */
    @Test
    public void testSearchForLocal() {
        System.out.println("searchForLocal");
        String s = "";
        GameBase instance = new GameBase();
        Locale expResult = null;
        Locale result = instance.searchForLocal(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrix method, of class GameBase.
     */
    @Test
    public void testGetMatrix() {
        System.out.println("getMatrix");
        GameBase instance = new GameBase();
        AdjacencyMatrixGraph<Locale, Roads> expResult = null;
        AdjacencyMatrixGraph<Locale, Roads> result = instance.getMatrix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMap method, of class GameBase.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        GameBase instance = new GameBase();
        Graph<Character, Aliance> expResult = null;
        Graph<Character, Aliance> result = instance.getMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertLocale method, of class GameBase.
     */
    @Test
    public void testInsertLocale() {
        System.out.println("insertLocale");
        String n = "";
        int d = 0;
        GameBase instance = new GameBase();
        boolean expResult = false;
        boolean result = instance.insertLocale(n, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRoads method, of class GameBase.
     */
    @Test
    public void testInsertRoads() {
        System.out.println("insertRoads");
        int d = 0;
        Locale l1 = null;
        Locale l2 = null;
        GameBase instance = new GameBase();
        boolean expResult = false;
        boolean result = instance.insertRoads(d, l1, l2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCharacter method, of class GameBase.
     */
    @Test
    public void testInsertCharacter() {
        System.out.println("insertCharacter");
        String n = "";
        int s = 0;
        Locale l = null;
        GameBase instance = new GameBase();
        boolean expResult = false;
        boolean result = instance.insertCharacter(n, s, l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertAliance method, of class GameBase.
     */
    @Test
    public void testInsertAliance() {
        System.out.println("insertAliance");
        boolean p = false;
        float cf = 0.0F;
        float pw = 0.0F;
        Character c1 = null;
        Character c2 = null;
        GameBase instance = new GameBase();
        boolean expResult = false;
        boolean result = instance.insertAliance(p, cf, pw, c1, c2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchForCharacter method, of class GameBase.
     */
    @Test
    public void testSearchForCharacter() {
        System.out.println("searchForCharacter");
        String s = "";
        GameBase instance = new GameBase();
        Character expResult = null;
        Character result = instance.searchForCharacter(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caminhoMaisFacil method, of class GameBase.
     */
    @Test
    public void testCaminhoMaisFacil() {
        System.out.println("caminhoMaisFacil");
        Locale l1 = null;
        Locale l2 = null;
        GameBase instance = new GameBase();
        Iterable<Roads> expResult = null;
        Iterable<Roads> result = instance.caminhoMaisFacil(l1, l2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cloneToDouble method, of class GameBase.
     */
    @Test
    public void testCloneToDouble() {
        System.out.println("cloneToDouble");
        AdjacencyMatrixGraph<Locale, Roads> graph = new AdjacencyMatrixGraph<>();
        GameBase instance = new GameBase();
        AdjacencyMatrixGraph<Locale, Double> expResult = null;
        AdjacencyMatrixGraph<Locale, Double> result = instance.cloneToDouble(graph);
        assertEquals(expResult, result);
    }
    
}
