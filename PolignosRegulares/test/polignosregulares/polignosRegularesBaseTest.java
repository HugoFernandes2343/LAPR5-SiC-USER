
package polignosregulares;

import PL.AVL;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


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

    /**
     * Test of getNomePoligno method, of class polignosRegularesBase.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetNomePoligno() throws IOException {
        System.out.println("getNomePoligno");

        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        List<Object> input = Files.lines(Paths.get("teste_lados_nome.txt")).collect(Collectors.toList());

        for (Object data : input) {
            String l = (String) data;
            String[] polygon = l.split(";");
            System.out.print(polygon[1]);
            System.out.print(instance.getNomePoligno(Integer.parseInt(polygon[0])));
            assertEquals(polygon[1], instance.getNomePoligno(Integer.parseInt(polygon[0])));
        }
    }

    /**
     * Test of getFullPolygonTree method, of class polignosRegularesBase.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetArvoreCompeta() throws IOException {
        System.out.println("getArvoreCompleta");

        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        AVL expResult = new AVL();
        List<Object> input = Files.lines(Paths.get("teste_lados_nome.txt")).collect(Collectors.toList());

        for (int i = 0; i < 999; i++) {
            String l = (String) input.get(i);
            String[] polygon = l.split(";");
            expResult.insert(new Prefixo(Integer.parseInt(polygon[0]), polygon[1]));
        }

        AVL result = instance.getArvoreCompleta();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNrLados method, of class polignosRegularesBase.
     */
    @Test
    public void testGetNrLados() throws IOException {
        System.out.println("getNrLados");
        String polNome = "enneahectaoctacontaoctagon";
        int expResult = 988;
        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");

        int result = instance.getNrLados(polNome);
        assertEquals(expResult, result);

    }

    /**
     * Test of getIntervaloNomes method, of class polignosRegularesBase.
     */
    @Test
    public void testGetIntervaloNomes() throws IOException {
        System.out.println("getIntervaloNomes");
        int min = 1;
        int max = 3;
        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        List<String> expResult = new ArrayList<>();
        expResult.add("trigon");
        expResult.add("digon");
        expResult.add("henagon");

        List<String> result = instance.getIntervaloNomes(min, max);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findLCA method, of class polignosRegularesBase.
     */
    @Test
    public void testFindLCA() throws IOException {
        System.out.println("findLCA");
        String a = "dodecagon";
        String b = "enneahectagon";
        polignosRegularesBase instance = new polignosRegularesBase("poligonos_prefixo_unidades.txt", "poligonos_prefixo_dezenas.txt", "poligonos_prefixo_centenas.txt");
        Prefixo expResult = new Prefixo(512, "pentahectadodecagon");
        Prefixo result = instance.findLCA(a, b);
        assertEquals(expResult, result);
    }

}
