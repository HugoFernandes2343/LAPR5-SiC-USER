/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import graphMap.Edge;
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
        
        expResult = new Locale();
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
        
        AdjacencyMatrixGraph<Locale, Road> expResult = new AdjacencyMatrixGraph<>();
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
        Graph<Character, Aliance> expResult = new Graph<>(false);
        Graph<Character, Aliance> result = instance.getMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of cloneToDouble method, of class GameBase.
     */
    @Test
    public void testCloneToDouble() {
        System.out.println("cloneToDouble");
        GameBase instance = new GameBase();
        Locale a = new Locale("porto", 50);
        Locale b = new Locale("lisboa", 40);
        instance.insertLocale("porto", 50);
        instance.insertLocale("lisboa", 40);
        instance.insertRoads(20, a, b);
        
        AdjacencyMatrixGraph<Locale, Double> expResult = new AdjacencyMatrixGraph<>();
        expResult.insertVertex(a);
        expResult.insertVertex(b);
        expResult.insertEdge(a, b, 20.0);
        AdjacencyMatrixGraph<Locale, Double> result = instance.cloneToDouble(instance.getMatrix());
        assertEquals(expResult.edges(), result.edges());
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
        GameBase instance = new GameBase();
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Character c = new Character("c", 20, new Locale());
        Character d = new Character("d", 20, new Locale());
        
        LinkedList<Character> expResult = new LinkedList<>();
        LinkedList<Character> result = new LinkedList<>();
        float powerExp = 0.0F;
        float power = instance.alianceMaisForte(result);
        
        assertEquals("Graph nao tem aliancas", powerExp, power, 0.0);
        
        instance.insertCharacter("a", 50, new Locale());
        instance.insertCharacter("b", 50, new Locale());
        instance.insertCharacter("c", 20, new Locale());
        instance.insertCharacter("d", 20, new Locale());
        instance.insertAliance(false, 0.5f, 50, a, b);
        instance.insertAliance(false, 0.5f, 20, d, c);
        expResult.add(a);
        expResult.add(b);
        power = instance.alianceMaisForte(result);
        assertEquals("Graph tem aliancas", expResult, result);
        
    }

    /**
     * Test of conquerLocale method, of class GameBase.
     */
    @Test
   public void testConquerLocale() {
        System.out.println("conquerLocale");

        GameBase instance = new GameBase();

        instance.insertLocale("Kyoto", 5);
        instance.insertLocale("Argel", 3);
        instance.insertLocale("Cartum", 6);
        instance.insertLocale("Munique", 8);

        Locale la = instance.searchForLocal("Kyoto");
        Locale lb = instance.searchForLocal("Argel");
        Locale lc = instance.searchForLocal("Cartum");
        Locale ld = instance.searchForLocal("Munique");

        instance.insertCharacter("Hilary", 7, lb);
        instance.insertCharacter("Trump", 35, la);
        instance.insertCharacter("Vladimir Putin", 6, lc);

        Character h = instance.searchForCharacter("Hilary");
        Character t = instance.searchForCharacter("Trump");
        Character vp = instance.searchForCharacter("Vladimir Putin");
        
        instance.searchForLocal("Kyoto").setOwner(instance.searchForCharacter("Trump"));
       instance.searchForLocal("Argel").setOwner(instance.searchForCharacter("Hilary"));
        instance.searchForLocal("Cartum").setOwner(instance.searchForCharacter("Vladimir Putin"));
        instance.searchForLocal("Munique").setOwner(instance.searchForCharacter("Trump"));
       
        instance.insertRoads(5, la, lb);
        instance.insertRoads(6, lb, lc);
        instance.insertRoads(40, la, lc);
        instance.insertRoads(50, ld, lc);

        LinkedList<Locale> path = new LinkedList<>();
        LinkedList<Locale> expPath = new LinkedList<>();
        expPath.add(instance.searchForLocal("Kyoto"));
        expPath.add(instance.searchForLocal("Argel"));
        expPath.add(instance.searchForLocal("Cartum"));
                
        double expResult = 33.0;
        double result = instance.conquerLocale(t, lc, path);
        
        assertEquals(expResult,result,0.0);
        assertEquals(expPath,path);
    }

    /**
     * Test of novaAlianca method, of class GameBase.
     */
    @Test
    public void testNovaAlianca() {
        System.out.println("novaAlianca");
        GameBase instance = new GameBase();
        Character c1 = new Character("dude", 50, new Locale());
        Character c2 = new Character("aliado", 50, new Locale());
        instance.insertCharacter("dude", 50, new Locale());
        instance.insertCharacter("aliado", 50, new Locale());
        
        Aliance expResult = new Aliance(false, 0.5f, 50, c1, c2);
        
        Aliance result = instance.novaAlianca(instance.getMap(), c1, c2);
        assertEquals("Compara primeira personagem da alianca", expResult.getFirstCharacter().getName(), result.getFirstCharacter().getName());
        assertEquals("Compara segunda personagem da alianca", expResult.getSecondCharacter().getName(), result.getSecondCharacter().getName());
        
        expResult = null;
        result = instance.novaAlianca(instance.getMap(), c1, c2);
        assertEquals("ja existe uma alianca entre as duas personagens", expResult, result);
    }

    /**
     * Test of todasAliancasPossiveis method, of class GameBase.
     */
    @Test
    public void testTodasAliancasPossiveis() {
        System.out.println("todasAliancasPossiveis");
        GameBase instance = new GameBase();
        Graph<Character, Aliance> expResult = new Graph<>(false);
        Graph<Character, Aliance> result = instance.todasAliancasPossiveis();
        assertEquals("sem personagens", expResult, result);
        
        Character a = new Character("a", 50, new Locale());
        Character b = new Character("b", 50, new Locale());
        Character c = new Character("c", 50, new Locale());
        instance.insertCharacter("a", 50, new Locale());
        instance.insertCharacter("b", 50, new Locale());
        instance.insertCharacter("c", 50, new Locale());
        expResult.insertVertex(a);
        expResult.insertVertex(b);
        expResult.insertVertex(c);
        Aliance ab = new Aliance(true, 0.5f, 50, a, b);
        Aliance bc = new Aliance(true, 0.5f, 50, b, c);
        Aliance ca = new Aliance(true, 0.5f, 50, c, a);
        expResult.insertEdge(a, b, ab, 50);
        expResult.insertEdge(b, c, bc, 50);
        expResult.insertEdge(c, a, ca, 50);
        
        result = instance.todasAliancasPossiveis();
        int contExpected = 3;
        int contResult = 0;
        
        ArrayList<Aliance> exp = new ArrayList<>();
        ArrayList<Aliance> res = new ArrayList<>();
        for (Edge<Character, Aliance> edge : expResult.edges()) {
            if (!exp.contains(edge.getElement())) {
                exp.add(edge.getElement());
            }
        }
        for (Edge<Character, Aliance> edge2 : result.edges()) {
            if (!res.contains(edge2.getElement())) {
                res.add(edge2.getElement());
            }
        }
        
        for (Aliance al1 : exp) {
            for (Aliance al2 : res) {
                if (al1.equalsSemPower(al2) || (al1.getFirstCharacter().equals(al2.getSecondCharacter()) && al2.getFirstCharacter().equals(al1.getSecondCharacter()))) {
                    contResult++;
                }
            }
        }
        assertEquals("com personagens", contExpected, contResult);
        
    }

    /**
     * Test of mundoSemLocaisAliados method, of class GameBase.
     */
    @Test
    public void testMundoSemLocaisAliados() {
        System.out.println("mundoSemLocaisAliados");
        Locale loc = new Locale("porto", 20);
        Character aliado = new Character ("aliado", 30,loc );
        loc.setOwner(aliado);
        GameBase instance = new GameBase();
        instance.getMatrix().insertVertex(loc);
        
        AdjacencyMatrixGraph<Locale, Road> graphRes = instance.mundoSemLocaisAliados(aliado);
        LinkedList<Locale> expResult = new LinkedList<>();
        LinkedList<Locale> result = new LinkedList<>();
        for(Locale l : graphRes.vertices()){
            result.add(l);
            System.out.println(l.getOwner().getName());
        }
        assertEquals(expResult, result);
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
        Locale l = new Locale();
        GameBase instance = new GameBase();
        instance.insertCharacter(n, s, l);
    }

    /**
     * Test of insertAliance method, of class GameBase.
     */
    @Test
    public void testInsertAliance() {
        System.out.println("insertAliance");
        boolean p = false;
        float cf = 0.5F;
        float pw = 50;
        Character c1 = new Character("dude", 50, new Locale());
        Character c2 = new Character("aliado", 50, new Locale());
        GameBase instance = new GameBase();
        instance.insertAliance(p, cf, pw, c1, c2);
    }

    /**
     * Test of searchForCharacter method, of class GameBase.
     */
    @Test
    public void testSearchForCharacter() {
        System.out.println("searchForCharacter");
        String s = "dude";
        Character c1 = new Character(s, 50, new Locale());
        GameBase instance = new GameBase();
        Character expResult = c1;
        instance.insertCharacter(s, 50, new Locale());
        Character result = instance.searchForCharacter(s);
        assertEquals("character existe, retorna o char", expResult, result);
        
        result = instance.searchForCharacter("falso");
        assertEquals("character nao existe, retorna um char vazio", new Character(), result);
    }

    /**
     * Test of caminhoMaisFacil method, of class GameBase.
     */
    @Test
    public void testCaminhoMaisFacil() {
        System.out.println("caminhoMaisFacil");
        LinkedList<Locale> path = new LinkedList<>();
        Locale A = new Locale("A", 10);
        Locale B = new Locale("B", 10);
        Locale C = new Locale("C", 10);
        Locale D = new Locale("D", 10);
        Locale E = new Locale("E", 10);
        Road r1 = new Road(A,C, 10);
        Road r3 = new Road(C,B, 10);
        Road r2 = new Road(A,D, 20);
        Road r4 = new Road(D,B, 20);
        GameBase instance = new GameBase();
        instance.insertLocale(A.getName(), A.getDifficulty());
        instance.insertLocale(B.getName(), B.getDifficulty());
        instance.insertLocale(C.getName(), C.getDifficulty());
        instance.insertLocale(D.getName(), D.getDifficulty());
        instance.insertLocale(E.getName(), E.getDifficulty());
        instance.insertRoads(r1.getDifficulty(), r1.getFirst(), r1.getSecond());
        instance.insertRoads(r3.getDifficulty(), r3.getFirst(), r3.getSecond());
        instance.insertRoads(r2.getDifficulty(), r2.getFirst(), r2.getSecond());
        instance.insertRoads(r4.getDifficulty(), r4.getFirst(), r4.getSecond());
        
        double expResult = 20.0;
        double result = instance.caminhoMaisFacil(instance.getMatrix(), path, A, B);
        assertEquals("Existe caminho",expResult, result, 0.0);
        
        expResult = -1;
        result = instance.caminhoMaisFacil(instance.getMatrix(), path, A, E);
        assertEquals("Nao xiste caminho",expResult, result, 0.0);
    }
    
}
