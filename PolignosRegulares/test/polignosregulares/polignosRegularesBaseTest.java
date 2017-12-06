/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polignosregulares;

import PL.AVL;
import java.io.IOException;
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
public class polignosRegularesBaseTest {

    public polignosRegularesBaseTest() {
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
     * Test of getUnid method, of class polignosRegularesBase.
     */
    @org.junit.Test
    public void testGetUnid() throws IOException {
        System.out.println("getUnid");
        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        AVL expResult = new AVL();
        expResult.insert(new Prefixo(1, "hena"));
        expResult.insert(new Prefixo(2, "di"));
        expResult.insert(new Prefixo(3, "tri"));
        expResult.insert(new Prefixo(4, "tetra"));
        expResult.insert(new Prefixo(5, "penta"));
        expResult.insert(new Prefixo(6, "hexa"));
        expResult.insert(new Prefixo(7, "hepta"));
        expResult.insert(new Prefixo(8, "octa"));
        expResult.insert(new Prefixo(9, "ennea"));
        AVL result = instance.getUnid();
        assertTrue(result.equals(expResult));
    }

    /**
     * Test of getDez method, of class polignosRegularesBase.
     */
    @org.junit.Test
    public void testGetDez() throws IOException {
        System.out.println("getDez");
        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        AVL expResult = new AVL();
        expResult.insert(new Prefixo(10, "deca"));
        expResult.insert(new Prefixo(11, "hendeca"));
        expResult.insert(new Prefixo(12, "dodeca"));
        expResult.insert(new Prefixo(13, "triskaideca"));
        expResult.insert(new Prefixo(14, "tetrakaideca"));
        expResult.insert(new Prefixo(15, "pentakaideca"));
        expResult.insert(new Prefixo(16, "hexakaideca"));
        expResult.insert(new Prefixo(17, "heptakaideca"));
        expResult.insert(new Prefixo(18, "octakaideca"));
        expResult.insert(new Prefixo(19, "enneakaideca"));
        expResult.insert(new Prefixo(20, "icosa"));
        expResult.insert(new Prefixo(21, "icosihena"));
        expResult.insert(new Prefixo(22, "icosidi"));
        expResult.insert(new Prefixo(23, "icositri"));
        expResult.insert(new Prefixo(24, "icositetra"));
        expResult.insert(new Prefixo(25, "icosipenta"));
        expResult.insert(new Prefixo(26, "icosihexa"));
        expResult.insert(new Prefixo(27, "icosihepta"));
        expResult.insert(new Prefixo(28, "icosiocta"));
        expResult.insert(new Prefixo(29, "icosiennea"));
        expResult.insert(new Prefixo(30, "triaconta"));
        expResult.insert(new Prefixo(40, "tetraconta"));
        expResult.insert(new Prefixo(50, "pentaconta"));
        expResult.insert(new Prefixo(60, "hexaconta"));
        expResult.insert(new Prefixo(70, "heptaconta"));
        expResult.insert(new Prefixo(80, "octaconta"));
        expResult.insert(new Prefixo(90, "enneaconta"));
        AVL result = instance.getDez();
        assertTrue(result.equals(expResult));
    }

    /**
     * Test of getCent method, of class polignosRegularesBase.
     */
    @org.junit.Test
    public void testGetCent() throws IOException {
        System.out.println("getCent");
        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        AVL expResult = new AVL();
        expResult.insert(new Prefixo(100, "hecta"));
        expResult.insert(new Prefixo(200, "dihecta"));
        expResult.insert(new Prefixo(300, "trihecta"));
        expResult.insert(new Prefixo(400, "tetrahecta"));
        expResult.insert(new Prefixo(500, "pentahecta"));
        expResult.insert(new Prefixo(600, "hexahecta"));
        expResult.insert(new Prefixo(700, "heptahecta"));
        expResult.insert(new Prefixo(800, "octahecta"));
        expResult.insert(new Prefixo(900, "enneahecta"));
        AVL result = instance.getCent();
        assertTrue(result.equals(expResult));
    }

}
