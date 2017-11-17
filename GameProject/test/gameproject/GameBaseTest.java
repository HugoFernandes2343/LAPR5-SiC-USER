/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import graphMap.Graph;
import graphMatrix.AdjacencyMatrixGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
        String s = "porto";
        GameBase instance = new GameBase();
        Locale expResult = new Locale(s, 100);
        instance.insertLocale(s, 100);
        instance.insertLocale("lisboa", 50);

        Locale result = instance.searchForLocal(s);
        assertEquals("Pocura por local que existe, deve ser igual.", expResult, result);

        expResult = null;
        result = instance.searchForLocal("braga");
        assertEquals("Pocura por local que não existe, deve ser igual.", expResult, result);

    }

    /**
     * Test of getMatrix method, of class GameBase.
     */
    @Test
    public void testGetMatrix() {
        System.out.println("getMatrix");
        GameBase instance = new GameBase();
        AdjacencyMatrixGraph<Locale, Road> expResult = null;
        AdjacencyMatrixGraph<Locale, Road> result = instance.getMatrix();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of cloneToDouble method, of class GameBase.
     */
    @Test
    public void testCloneToDouble() {
        System.out.println("cloneToDouble");
        AdjacencyMatrixGraph<Locale, Road> graph = new AdjacencyMatrixGraph<>();
        GameBase instance = new GameBase();
        AdjacencyMatrixGraph<Locale, Double> expResult = null;
        AdjacencyMatrixGraph<Locale, Double> result = instance.cloneToDouble(graph);
        assertEquals(expResult, result);
    }

    /**
     * Test of caminhoMaisFacil method, of class GameBase.
     */
    @Test
    public void testCaminhoMaisFacil_4args_1() {
        System.out.println("caminhoMaisFacil");
        AdjacencyMatrixGraph<Locale, Road> matrix = null;
        Locale l1 = null;
        Locale l2 = null;
        double dist = 0.0;
        GameBase instance = new GameBase();
        LinkedList<Locale> expResult = null;
        LinkedList<Locale> result = instance.caminhoMaisFacil(matrix, l1, l2, dist);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caminhoMaisFacil method, of class GameBase.
     */
    @Test
    public void testCaminhoMaisFacil_4args_2() {
        System.out.println("caminhoMaisFacil");
        AdjacencyMatrixGraph<Locale, Road> matrix = null;
        LinkedList<Locale> path = null;
        Locale l1 = null;
        Locale l2 = null;
        GameBase instance = new GameBase();
        double expResult = 0.0;
        double result = instance.caminhoMaisFacil(matrix, path, l1, l2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of todosAliados method, of class GameBase.
     */
    @Test
    public void testTodosAliados() {
        System.out.println("todosAliados");
        Character dude = new Character("dude", 40, new Locale());
        Character aliado = new Character("ali", 50, new Locale());
        Character inimigo = new Character("outro", 40, new Locale());
        GameBase instance = new GameBase();

        instance.insertCharacter("dude", 40, new Locale());
        instance.insertCharacter("ali", 50, new Locale());
        instance.insertCharacter("outro", 40, new Locale());
        instance.insertAliance(false, 0.5f, 45, dude, aliado);

        ArrayList<Character> expResult = new ArrayList<>();
        expResult.add(aliado);
        ArrayList<Character> result = instance.todosAliados(dude);
        assertEquals("deve retornar lista com um aliado", expResult, result);

        expResult = new ArrayList<>();
        result = instance.todosAliados(inimigo);
        assertEquals("deve retornar lista vazia", expResult, result);

        expResult = new ArrayList<>();
        result = instance.todosAliados(new Character());
        assertEquals("deve retornar lista vazia, vertice nao existe", expResult, result);
    }

    /**
     * Test of alianceMaisForte method, of class GameBase.
     */
    @Test
    public void testAlianceMaisForte() {
        System.out.println("alianceMaisForte");
        LinkedList<Character> membros = null;
        GameBase instance = new GameBase();
        float expResult = 0.0F;
        float result = instance.alianceMaisForte(membros);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conquerLocale method, of class GameBase.
     */
    @Test
    public void testConquerLocale() {
        System.out.println("conquerLocale");
        Character c = null;
        Locale l = null;
        LinkedList<Locale> path = null;
        double str_conquer = 0.0;
        GameBase instance = new GameBase();
        boolean expResult = false;
        boolean result = instance.conquerLocale(c, l, path, str_conquer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novaAlianca method, of class GameBase.
     */
    @Test
    public void testNovaAlianca() {
        System.out.println("novaAlianca");
        Graph<Character, Aliance> map = null;
        Character a = null;
        Character b = null;
        GameBase instance = new GameBase();
        Aliance expResult = null;
        Aliance result = instance.novaAlianca(map, a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of todasAliancasPossiveis method, of class GameBase.
     */
    @Test
    public void testTodasAliancasPossiveis() {
        System.out.println("todasAliancasPossiveis");
        GameBase instance = new GameBase();
        Graph<Character, Aliance> expResult = null;
        Graph<Character, Aliance> result = instance.todasAliancasPossiveis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mundoSemLocaisAliados method, of class GameBase.
     */
    @Test
    public void testMundoSemLocaisAliados() {
        System.out.println("mundoSemLocaisAliados");
        Character aliado = null;
        GameBase instance = new GameBase();
        AdjacencyMatrixGraph<Locale, Road> expResult = null;
        AdjacencyMatrixGraph<Locale, Road> result = instance.mundoSemLocaisAliados(aliado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of melhorLocAlConquista method, of class GameBase.
     */
    @Test
    public void testMelhorLocAlConquista() {
        System.out.println("melhorLocAlConquista");
        Character pers = null;
        Locale dest = null;
        HashMap<Character, LinkedList<Locale>> listaLoc = null;
        GameBase instance = new GameBase();
        float expResult = 0.0F;
        float result = instance.melhorLocAlConquista(pers, dest, listaLoc);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertLocale method, of class GameBase.
     */
    @Test
    public void testInsertLocale() {
        System.out.println("insertLocale");
        String n = "porto";
        int d = 30;
        GameBase gb = new GameBase();
        gb.insertLocale(n, d);
    }

    /**
     * Test of insertRoads method, of class GameBase.
     */
    @Test
    public void testInsertRoads() {
        System.out.println("insertRoads");
        int d = 0;
        Locale l1 = new Locale("porto", 20);
        Locale l2 = new Locale("lisboa", 30);
        GameBase instance = new GameBase();
        instance.insertRoads(d, l1, l2);
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
        instance.insertCharacter(n, s, l);
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
        float cf = 0.6F;
        float pw = 0.0F;
//        Character c1 = new Character("char1", );
        Character c2 = null;
        GameBase instance = new GameBase();
//        instance.insertAliance(p, cf, pw, c1, c2);
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

}
