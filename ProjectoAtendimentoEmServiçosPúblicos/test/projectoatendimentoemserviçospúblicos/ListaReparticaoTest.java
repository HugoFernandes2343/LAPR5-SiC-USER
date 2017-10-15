package projectoatendimentoemserviçospúblicos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class ListaReparticaoTest {

    public ListaReparticaoTest() {
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
     * Test of addReparticao method, of class ListaReparticao.
     */
    @Test
    public void testAddReparticao() {
        System.out.println("addReparticao");
        Reparticao rep = new Reparticao();
        ListaReparticao instance = new ListaReparticao();
        instance.addReparticao(rep);
    }

    /**
     * Test of getListaReparticao method, of class ListaReparticao.
     */
    @Test
    public void testGetListaReparticao() {
        System.out.println("getListaReparticao");
        ListaReparticao instance = new ListaReparticao();
        DoublyLinkedList<Reparticao> expResult = new DoublyLinkedList<>();
        DoublyLinkedList<Reparticao> result = instance.getListaReparticao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getReparticaoPorNumero method, of class ListaReparticao.
     */
    @Test
    public void testGetReparticaoPorNumero() {
        System.out.println("getReparticaoPorNumero");
        int numero = 1111;
        List<String> serv = new ArrayList<>();
        Reparticao rep = new Reparticao("porto", 1111, 4490, serv);
        ListaReparticao instance = new ListaReparticao();
        instance.addReparticao(rep);

        Reparticao expResult = rep;
        Reparticao result = instance.getReparticaoPorNumero(numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of getReparticaoPorPostal method, of class ListaReparticao.
     */
    @Test
    public void testGetReparticaoPorPostal() {
        System.out.println("getReparticaoPorPostal");
        int cod = 4490;
        ListaReparticao instance = new ListaReparticao();
        List<String> serv = new ArrayList<>();
        Reparticao rep = new Reparticao("porto", 1111, 4490, serv);
        instance.addReparticao(rep);

        Reparticao expResult = rep;
        Reparticao result = instance.getReparticaoPorPostal(cod);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDuplicates method, of class ListaReparticao.
     */
    @Test
    public void testCheckDuplicates() {
        System.out.println("checkDuplicates");
        List<String> serv = new ArrayList<>();
        Reparticao instance1 = new Reparticao("porto", 1111, 4490, serv);
        Reparticao instance2 = new Reparticao("porto", 1111, 4490, serv);
        ListaReparticao instance = new ListaReparticao();
        instance.getListaReparticao().addLast(instance1);
        boolean expResult = true;
        boolean result = instance.checkDuplicates(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of NovaReparticao method, of class ListaReparticao.
     */
    @Test
    public void testNovaReparticao() {
        System.out.println("NovaReparticao");
        Cidadao cid1 = new Cidadao("teste1", 999999999, "@", "4490-479", 1111);
        Cidadao cid2 = new Cidadao("teste2", 888888888, "@", "4482-479", 1111);

        Reparticao instance1 = new Reparticao("porto", 1111, 4490, new ArrayList<>());
        instance1.addCidadao(cid1);
        instance1.addCidadao(cid2);

        ListaReparticao lr = new ListaReparticao();
        lr.addReparticao(instance1);
        lr.NovaReparticao("braga", 2222, 4482, new ArrayList<>());

        DoublyLinkedList listExp = new DoublyLinkedList<>();
        listExp.addLast(cid2);
        DoublyLinkedList listResult = lr.getReparticaoPorNumero(2222).getListaCidadao().getListaCidadao();

        boolean expResult = true;
        boolean result = listExp.equals(listResult);
        System.out.println(listResult.toString());
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveReparticao method, of class ListaReparticao.
     */
    @Test
    public void testRemoveReparticao() {
        System.out.println("RemoveReparticao");
        Cidadao cid1 = new Cidadao("teste1", 999999999, "@", "4490-479", 1111);
        Cidadao cid2 = new Cidadao("teste2", 888888888, "@", "4482-479", 2222);

        Reparticao rep1 = new Reparticao("porto", 1111, 4490, new ArrayList<>());
        rep1.addCidadao(cid1);
        Reparticao rep2 = new Reparticao("braga", 2222, 4482, new ArrayList<>());
        rep2.addCidadao(cid2);

        ListaReparticao instance = new ListaReparticao();
        instance.addReparticao(rep1);
        instance.addReparticao(rep2);

        instance.RemoveReparticao(rep2);

        DoublyLinkedList expResult = new DoublyLinkedList<>();
        expResult.addLast(cid1);
        expResult.addLast(cid2);
        DoublyLinkedList result = instance.getReparticaoPorNumero(1111).getListaCidadao().getListaCidadao();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCidadao method, of class ListaReparticao.
     */
    @Test
    public void testAddCidadao() {
        System.out.println("addCidadao");
        Cidadao cid = new Cidadao("teste1", 999999999, "@", "4490-479", 1111);
        Reparticao rep = new Reparticao("braga", 2222, 4482, new ArrayList<>());

        ListaReparticao instance = new ListaReparticao();
        instance.addReparticao(rep);
        instance.addCidadao(cid);

        DoublyLinkedList expResult = new DoublyLinkedList<>();
        expResult.addLast(cid);
        DoublyLinkedList result = instance.getReparticaoPorNumero(2222).getListaCidadao().getListaCidadao();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDuplicatesCid method, of class ListaReparticao.
     */
    @Test
    public void testCheckDuplicatesCid() {
        System.out.println("checkDuplicatesCid");
        Cidadao cid = new Cidadao("teste1", 999999999, "@", "4490-479", 1111);
        Reparticao rep = new Reparticao("braga", 2222, 4482, new ArrayList<>());
        rep.addCidadao(cid);

        ListaReparticao instance = new ListaReparticao();
        instance.addReparticao(rep);

        boolean expResult = true;
        boolean result = instance.checkDuplicatesCid(cid);
        assertEquals(expResult, result);
    }

    /**
     * Test of ImprimeCids method, of class ListaReparticao.
     */
    @Test
    public void testImprimeCids() {
        System.out.println("ImprimeCids");
        Cidadao cid = new Cidadao("teste1", 999999999, "@", "4490-479", 1111);
        Reparticao rep = new Reparticao("braga", 2222, 4482, new ArrayList<>());
        rep.addCidadao(cid);

        ListaReparticao instance = new ListaReparticao();
        instance.addReparticao(rep);

        PrintStream oldOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        instance.ImprimeCids();

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

        assertTrue(output.contains("Repartição: [braga, 2222] - Cidadão: 999999999"));
    }

    /**
     * Test of getReparticaoPorServicoECodigoPostal method, of class
     * ListaReparticao.
     */
    @Test
    public void testGetReparticaoPorServicoECodigoPostal() throws Exception {
        System.out.println("getListaReparticoesPorServicoECodigoPostal");
        ListaReparticao instance = new ListaReparticao();
        List<String> serv = new ArrayList<>();
        serv.add("A");
        Reparticao rep1 = new Reparticao("braga", 2222, 4482, serv);
        serv.add("B");
        Reparticao rep2 = new Reparticao("porto", 1111, 4490, serv);
        serv.add("C");
        Reparticao rep3 = new Reparticao("maia", 3333, 4495, serv);
        instance.addReparticao(rep1);
        instance.addReparticao(rep2);
        instance.addReparticao(rep3);
        for (Servico s : rep3.getListaServicos().getListaServicos()) {
            System.out.println(s.getLetraCodigo());
        }

        Servico servTest = new Servico("c");
        boolean expResult = true;
        Reparticao repResult = instance.getReparticaoPorServicoECodigoPostal(servTest, 4482);
        boolean result = repResult.equals(rep3);
        assertEquals(expResult, result);

        servTest = new Servico("b");
        repResult = instance.getReparticaoPorServicoECodigoPostal(servTest, 4482);
        result = repResult.equals(rep2);
        assertEquals(expResult, result);
    }

}
