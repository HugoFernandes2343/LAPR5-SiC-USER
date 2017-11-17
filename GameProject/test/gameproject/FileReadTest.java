/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import graphMap.Edge;
import java.util.LinkedList;
import java.util.Iterator;
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
public class FileReadTest {

    public FileReadTest() {
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
     * Test of FileRead method, of class FileRead.
     */
    @Test
    public void testFileRead() throws Exception {
        System.out.println("FileRead");
        FileRead instance = new FileRead();
        GameBase tempGb = instance.getGamebase();

        // Ir buscar os locais que sao lidos
        LinkedList<Locale> llLocaleInput = new LinkedList<>();
        Iterator itrLocale = tempGb.getMatrix().vertices().iterator();
        while (itrLocale.hasNext()) {
            llLocaleInput.add((Locale) itrLocale.next());
        }

        // Ir buscar as estradas que sao lidas
        LinkedList<Road> llRoadInput = new LinkedList<>();
        Iterator itrRoad = tempGb.getMatrix().edges().iterator();
        while (itrRoad.hasNext()) {
            llRoadInput.add((Road) itrRoad.next());
        }

        // Ir buscar as personagens que sao lidas
        LinkedList<Character> llCharacterInput = new LinkedList<>();
        Iterator itrCharacter = tempGb.getMap().vertices().iterator();
        while (itrCharacter.hasNext()) {
            llCharacterInput.add((Character) itrCharacter.next());
        }

        // Ir buscar as llAlianceTest que sao lidance       
        LinkedList<Aliance> llAlianceInput = new LinkedList<>();
       for(Edge<Character, Aliance> edge : tempGb.getMap().edges()){
          if(!llAlianceInput.contains(edge.getElement())){
            llAlianceInput.add(edge.getElement());
          }
       }

        LinkedList<Locale> llLocaleTest = new LinkedList<>();

        Locale Local0 = new Locale("Local0", 30);
        llLocaleTest.add(Local0);
        Locale Local1 = new Locale("Local1", 29);
        llLocaleTest.add(Local1);
        Locale Local2 = new Locale("Local2", 21);
        llLocaleTest.add(Local2);
        Locale Local3 = new Locale("Local3", 23);
        llLocaleTest.add(Local3);
        Locale Local4 = new Locale("Local4", 30);
        llLocaleTest.add(Local4);
        Locale Local5 = new Locale("Local5", 23);
        llLocaleTest.add(Local5);
        Locale Local6 = new Locale("Local6", 27);
        llLocaleTest.add(Local6);
        Locale Local7 = new Locale("Local7", 26);
        llLocaleTest.add(Local7);
        Locale Local8 = new Locale("Local8", 27);
        llLocaleTest.add(Local8);
        Locale Local9 = new Locale("Local9", 29);
        llLocaleTest.add(Local9);
        Locale Local10 = new Locale("Local10", 25);
        llLocaleTest.add(Local10);
        Locale Local11 = new Locale("Local11", 36);
        llLocaleTest.add(Local11);
        Locale Local12 = new Locale("Local12", 22);
        llLocaleTest.add(Local12);
        Locale Local13 = new Locale("Local13", 31);
        llLocaleTest.add(Local13);
        Locale Local14 = new Locale("Local14", 26);
        llLocaleTest.add(Local14);
        Locale Local15 = new Locale("Local15", 38);
        llLocaleTest.add(Local15);
        Locale Local16 = new Locale("Local16", 21);
        llLocaleTest.add(Local16);
        Locale Local17 = new Locale("Local17", 34);
        llLocaleTest.add(Local17);
        Locale Local18 = new Locale("Local18", 30);
        llLocaleTest.add(Local18);
        Locale Local19 = new Locale("Local19", 33);
        llLocaleTest.add(Local19);
        Locale Local20 = new Locale("Local20", 25);
        llLocaleTest.add(Local20);
        Locale Local21 = new Locale("Local21", 32);
        llLocaleTest.add(Local21);
        Locale Local22 = new Locale("Local22", 32);
        llLocaleTest.add(Local22);
        Locale Local23 = new Locale("Local23", 26);
        llLocaleTest.add(Local23);
        Locale Local24 = new Locale("Local24", 34);
        llLocaleTest.add(Local24);
        Locale Local25 = new Locale("Local25", 30);
        llLocaleTest.add(Local25);
        Locale Local26 = new Locale("Local26", 34);
        llLocaleTest.add(Local26);
        Locale Local27 = new Locale("Local27", 38);
        llLocaleTest.add(Local27);
        Locale Local28 = new Locale("Local28", 20);
        llLocaleTest.add(Local28);
        Locale Local29 = new Locale("Local29", 31);
        llLocaleTest.add(Local29);
        assertEquals(llLocaleTest, llLocaleInput);

        LinkedList<Road> llRoadTest = new LinkedList<>();
        llRoadTest.add(new Road(Local0, Local1, 29));
        llRoadTest.add(new Road(Local0, Local3, 20));
        llRoadTest.add(new Road(Local0, Local6, 26));
        llRoadTest.add(new Road(Local0, Local9, 20));
        llRoadTest.add(new Road(Local0, Local12, 23));
        llRoadTest.add(new Road(Local0, Local15, 23));
        llRoadTest.add(new Road(Local0, Local18, 29));
        llRoadTest.add(new Road(Local0, Local19, 28));
        llRoadTest.add(new Road(Local0, Local22, 23));
        llRoadTest.add(new Road(Local0, Local23, 22));
        llRoadTest.add(new Road(Local0, Local26, 27));
        llRoadTest.add(new Road(Local0, Local28, 24));
        llRoadTest.add(new Road(Local1, Local4, 21));
        llRoadTest.add(new Road(Local1, Local8, 25));
        llRoadTest.add(new Road(Local1, Local9, 29));
        llRoadTest.add(new Road(Local1, Local14, 25));
        llRoadTest.add(new Road(Local1, Local15, 28));
        llRoadTest.add(new Road(Local1, Local16, 20));
        llRoadTest.add(new Road(Local1, Local17, 26));
        llRoadTest.add(new Road(Local2, Local3, 27));
        llRoadTest.add(new Road(Local2, Local5, 24));
        llRoadTest.add(new Road(Local2, Local11, 26));
        llRoadTest.add(new Road(Local2, Local14, 24));
        llRoadTest.add(new Road(Local2, Local22, 26));
        llRoadTest.add(new Road(Local2, Local27, 24));
        llRoadTest.add(new Road(Local3, Local9, 26));
        llRoadTest.add(new Road(Local3, Local11, 27));
        llRoadTest.add(new Road(Local3, Local14, 26));
        llRoadTest.add(new Road(Local3, Local16, 21));
        llRoadTest.add(new Road(Local3, Local17, 28));
        llRoadTest.add(new Road(Local3, Local21, 28));
        llRoadTest.add(new Road(Local3, Local22, 29));
        llRoadTest.add(new Road(Local4, Local6, 28));
        llRoadTest.add(new Road(Local4, Local7, 24));
        llRoadTest.add(new Road(Local4, Local9, 25));
        llRoadTest.add(new Road(Local4, Local16, 25));
        llRoadTest.add(new Road(Local4, Local17, 22));
        llRoadTest.add(new Road(Local4, Local21, 29));
        llRoadTest.add(new Road(Local4, Local24, 26));
        llRoadTest.add(new Road(Local5, Local10, 28));
        llRoadTest.add(new Road(Local5, Local11, 25));
        llRoadTest.add(new Road(Local5, Local12, 24));
        llRoadTest.add(new Road(Local5, Local15, 27));
        llRoadTest.add(new Road(Local5, Local17, 25));
        llRoadTest.add(new Road(Local5, Local24, 20));
        llRoadTest.add(new Road(Local5, Local26, 20));
        llRoadTest.add(new Road(Local6, Local8, 25));
        llRoadTest.add(new Road(Local6, Local9, 20));
        llRoadTest.add(new Road(Local6, Local15, 21));
        llRoadTest.add(new Road(Local6, Local20, 29));
        llRoadTest.add(new Road(Local6, Local21, 28));
        llRoadTest.add(new Road(Local6, Local28, 21));
        llRoadTest.add(new Road(Local6, Local29, 29));
        llRoadTest.add(new Road(Local7, Local8, 29));
        llRoadTest.add(new Road(Local7, Local13, 25));
        llRoadTest.add(new Road(Local7, Local19, 21));
        llRoadTest.add(new Road(Local7, Local25, 20));
        llRoadTest.add(new Road(Local7, Local27, 22));
        llRoadTest.add(new Road(Local8, Local10, 28));
        llRoadTest.add(new Road(Local8, Local13, 22));
        llRoadTest.add(new Road(Local8, Local17, 25));
        llRoadTest.add(new Road(Local8, Local18, 29));
        llRoadTest.add(new Road(Local8, Local20, 29));
        llRoadTest.add(new Road(Local8, Local21, 22));
        llRoadTest.add(new Road(Local8, Local24, 26));
        llRoadTest.add(new Road(Local9, Local10, 26));
        llRoadTest.add(new Road(Local9, Local11, 23));
        llRoadTest.add(new Road(Local9, Local20, 29));
        llRoadTest.add(new Road(Local9, Local27, 28));
        llRoadTest.add(new Road(Local10, Local12, 23));
        llRoadTest.add(new Road(Local10, Local16, 27));
        llRoadTest.add(new Road(Local10, Local19, 27));
        llRoadTest.add(new Road(Local10, Local25, 24));
        llRoadTest.add(new Road(Local10, Local29, 23));
        llRoadTest.add(new Road(Local11, Local14, 27));
        llRoadTest.add(new Road(Local11, Local18, 22));
        llRoadTest.add(new Road(Local11, Local26, 20));
        llRoadTest.add(new Road(Local11, Local29, 21));
        llRoadTest.add(new Road(Local12, Local14, 21));
        llRoadTest.add(new Road(Local12, Local25, 21));
        llRoadTest.add(new Road(Local12, Local26, 27));
        llRoadTest.add(new Road(Local12, Local28, 25));
        llRoadTest.add(new Road(Local13, Local15, 24));
        llRoadTest.add(new Road(Local13, Local17, 25));
        llRoadTest.add(new Road(Local13, Local18, 26));
        llRoadTest.add(new Road(Local13, Local21, 20));
        llRoadTest.add(new Road(Local13, Local24, 22));
        llRoadTest.add(new Road(Local13, Local26, 24));
        llRoadTest.add(new Road(Local13, Local29, 21));
        llRoadTest.add(new Road(Local14, Local18, 25));
        llRoadTest.add(new Road(Local14, Local19, 21));
        llRoadTest.add(new Road(Local14, Local26, 22));
        llRoadTest.add(new Road(Local14, Local28, 23));
        llRoadTest.add(new Road(Local15, Local16, 27));
        llRoadTest.add(new Road(Local15, Local17, 27));
        llRoadTest.add(new Road(Local15, Local22, 22));
        llRoadTest.add(new Road(Local15, Local24, 20));
        llRoadTest.add(new Road(Local15, Local27, 27));
        llRoadTest.add(new Road(Local16, Local19, 20));
        llRoadTest.add(new Road(Local16, Local20, 25));
        llRoadTest.add(new Road(Local16, Local23, 23));
        llRoadTest.add(new Road(Local16, Local27, 22));
        llRoadTest.add(new Road(Local16, Local28, 25));
        llRoadTest.add(new Road(Local17, Local20, 26));
        llRoadTest.add(new Road(Local17, Local24, 26));
        llRoadTest.add(new Road(Local17, Local26, 25));
        llRoadTest.add(new Road(Local18, Local22, 28));
        llRoadTest.add(new Road(Local18, Local25, 23));
        llRoadTest.add(new Road(Local18, Local27, 21));
        llRoadTest.add(new Road(Local18, Local28, 29));
        llRoadTest.add(new Road(Local19, Local22, 23));
        llRoadTest.add(new Road(Local20, Local21, 27));
        llRoadTest.add(new Road(Local20, Local23, 26));
        llRoadTest.add(new Road(Local20, Local25, 28));
        llRoadTest.add(new Road(Local20, Local29, 29));
        llRoadTest.add(new Road(Local21, Local22, 22));
        llRoadTest.add(new Road(Local21, Local23, 24));
        llRoadTest.add(new Road(Local21, Local24, 21));
        llRoadTest.add(new Road(Local21, Local25, 23));
        llRoadTest.add(new Road(Local21, Local27, 24));
        llRoadTest.add(new Road(Local21, Local29, 29));
        llRoadTest.add(new Road(Local22, Local23, 24));
        llRoadTest.add(new Road(Local22, Local25, 27));
        llRoadTest.add(new Road(Local22, Local28, 20));
        llRoadTest.add(new Road(Local22, Local29, 24));
        llRoadTest.add(new Road(Local23, Local24, 25));
        llRoadTest.add(new Road(Local24, Local26, 21));
        llRoadTest.add(new Road(Local25, Local26, 22));
        llRoadTest.add(new Road(Local25, Local29, 22));
        llRoadTest.add(new Road(Local26, Local28, 22));
        llRoadTest.add(new Road(Local27, Local28, 20));
        llRoadTest.add(new Road(Local28, Local29, 22));

        assertEquals(llRoadTest, llRoadInput);

        LinkedList<Character> llCharacterTest = new LinkedList<>();

        
        Character Pers0 = new Character("Pers0", 195, Local2);
        llCharacterTest.add(Pers0);        
        Character Pers1 = new Character("Pers1", 111, Local4);
        llCharacterTest.add(Pers1);
        Character Pers2 = new Character("Pers2", 112, Local6);
        llCharacterTest.add(Pers2);
        Character Pers3 = new Character("Pers3", 429, Local8);
        llCharacterTest.add(Pers3);
        Character Pers4 = new Character("Pers4", 262, Local10);
        llCharacterTest.add(Pers4);
        Character Pers5 = new Character("Pers5", 126, Local12);
        llCharacterTest.add(Pers5);
        Character Pers6 = new Character("Pers6", 121, Local14);
        llCharacterTest.add(Pers6);
        Character Pers7 = new Character("Pers7", 354, Local16);
        llCharacterTest.add(Pers7);
        Character Pers8 = new Character("Pers8", 481, Local18);
        llCharacterTest.add(Pers8);
        Character Pers9 = new Character("Pers9", 463, Local20);
        llCharacterTest.add(Pers9);
        
        assertEquals(llCharacterTest, llCharacterInput);
        System.out.println(Pers9.getStartingLocale().getName());
        
        LinkedList<Aliance> llAlianceTest = new LinkedList<>();
        
        llAlianceTest.add(new Aliance(true, (float) 0.8, (Pers0.getStrength()+ Pers3.getStrength())* (float)0.8, Pers0, Pers3));
        llAlianceTest.add(new Aliance(true, (float) 0.5,(Pers0.getStrength()+ Pers4.getStrength())* (float)0.5, Pers0, Pers4));
        llAlianceTest.add(new Aliance(true, (float) 0.5,(Pers1.getStrength()+ Pers2.getStrength())* (float)0.5, Pers1, Pers2));
        llAlianceTest.add(new Aliance(true, (float) 0.5,(Pers1.getStrength()+ Pers3.getStrength())* (float)0.5, Pers1, Pers3));
        llAlianceTest.add(new Aliance(true, (float) 0.2,(Pers1.getStrength()+ Pers4.getStrength())* (float)0.2, Pers1, Pers4));
        llAlianceTest.add(new Aliance(true, (float) 0.5,(Pers3.getStrength()+ Pers4.getStrength())* (float)0.5, Pers3, Pers4));
        llAlianceTest.add(new Aliance(false, (float) 0.5,(Pers5.getStrength()+ Pers7.getStrength())* (float)0.5, Pers5, Pers7));
        llAlianceTest.add(new Aliance(true, (float) 0.8,(Pers6.getStrength()+ Pers8.getStrength())* (float)0.8, Pers6, Pers8));
        llAlianceTest.add(new Aliance(true, (float) 0.5,(Pers7.getStrength()+ Pers8.getStrength())* (float)0.5, Pers7, Pers8));
        llAlianceTest.add(new Aliance(true, (float) 0.5,(Pers7.getStrength()+ Pers9.getStrength())* (float)0.5, Pers7, Pers9));
        
        assertEquals(llAlianceTest, llAlianceInput);
    }
}
