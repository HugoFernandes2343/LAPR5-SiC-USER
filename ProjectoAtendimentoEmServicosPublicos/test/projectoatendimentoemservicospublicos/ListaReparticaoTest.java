package projectoatendimentoemservicospublicos;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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

    /**
     * Test of servicoComMaiorProcura method, of class ListaReparticao.
     */
    @Test
    public void testServicoComMaiorProcura() {
        System.out.println("servicoComMaiorProcura");
        ListaReparticao instance = new ListaReparticao();
        List<String> serv = new ArrayList<>();
        serv.add("a");
        serv.add("b");
        Reparticao rep = new Reparticao("porto", 1111, 4490, serv);
        Servico serv1 = new Servico("a");
        Senha s1 = new Senha(999999999, "a", 1);
        Senha s2 = new Senha(888888888, "a", 2);
        Senha s3 = new Senha(777777777, "a", 3);
        Senha s4 = new Senha(666666666, "b", 1);

        for (Servico s : rep.getListaServicos().getListaServicos()) {
            if (s.getLetraCodigo().equalsIgnoreCase("a")) {
                s.getListaSenha().getListaSenha().add(s1);
                s.getListaSenha().getListaSenha().add(s2);
                s.getListaSenha().getListaSenha().add(s3);
            } else {
                s.getListaSenha().getListaSenha().add(s4);
            }
        }

        instance.addReparticao(rep);
        List<Servico> listServExpRes = new ArrayList<>();
        listServExpRes.add(serv1);

        boolean expResult = true;
        boolean result = false;
        Iterator itr = listServExpRes.iterator();
        for (Servico s : instance.servicoComMaiorProcura()) {
            Servico temp = (Servico) itr.next();
            result = temp.equals(s);
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of AbandonarFilas method, of class ListaReparticao.
     */
    @Test
    public void testAbandonarFilas() {
        System.out.println("AbandonarFilas");
        Cidadao c1 = new Cidadao("Ana", 111222333, "ana@gmail.com", "4200-072", 1235);
        Cidadao c2 = new Cidadao("Berta", 223344, "berta@gmail.com", "4200-071", 1235);
        ListaReparticao instance = new ListaReparticao();
        List<String> servR1 = new ArrayList<>();
        servR1.add("A");
        servR1.add("B");
        Reparticao r1 = new Reparticao("Maia", 1235, 4470, servR1);

        r1.addCidadao(c1);
        r1.addCidadao(c2);
        Senha s1 = new Senha(111222333, "A", 1);
        Senha s2 = new Senha(223344, "A", 2);
        for (Servico s : r1.getListaServicos().getListaServicos()) {
            if (s.getLetraCodigo().equalsIgnoreCase("a")) {
                s.getListaSenha().getListaSenha().add(s1);
                s.getListaSenha().getListaSenha().add(s2);
            }
        }
        instance.addReparticao(r1);

        PriorityQueue<Senha> senhaListExp = new PriorityQueue<>();
        senhaListExp.add(s1);

        instance.AbandonarFilas(c1);
        PriorityQueue<Senha> senhaRes = new PriorityQueue<>();
        for (Servico ser : instance.getReparticaoPorNumero(1235).getListaServicos().getListaServicos()) {
            if (ser.getLetraCodigo().equalsIgnoreCase("a")) {
                senhaRes = ser.getListaSenha().getListaSenha();
            }
        }

        Servico serv1 = r1.getListaServicos().getListaServicos().get(0);
        serv1.getListaSenha().getListaSenha().add(s1);
        serv1.getListaSenha().getListaSenha().add(s2);

        boolean expResult = true;
        boolean result = false;
        Iterator itr = senhaRes.iterator();
        for (Senha s : senhaListExp) {
            Senha temp = (Senha) itr.next();
            result = temp.equals(s);
        }

        assertEquals(expResult, result);

    }

    /**
     * Test of getUtilizacaoRep method, of class ListaReparticao.
     */
    @Test
    public void testGetUtilizacaoRep() {
        System.out.println("getUtilizacaoRep");

        List<String> serv = new ArrayList<>();
        serv.add("A");

        ListaReparticao instance = new ListaReparticao();

        Cidadao c1 = new Cidadao("Ana", 111222333, "ana@gmail.com", "4200-072", 1235);
        Cidadao c2 = new Cidadao("Berta", 223344, "berta@gmail.com", "4200-071", 1235);
        Cidadao c3 = new Cidadao("Manuel", 2235324, "manuel@gmail.com", "4200-070", 1235);
        Reparticao rep = new Reparticao("porto", 1235, 4490, serv);
        rep.addCidadao(c1);
        rep.addCidadao(c2);
        rep.addCidadao(c3);

        Senha s1 = new Senha(111222333, "A", 1);
        Senha s2 = new Senha(223344, "A", 2);
        Senha s3 = new Senha(2235324, "A", 3);

        for (Servico s : rep.getListaServicos().getListaServicos()) {
            if (s.getLetraCodigo().equalsIgnoreCase("A")) {
                s.getListaSenha().getListaSenha().add(s1);
                s.getListaSenha().getListaSenha().add(s2);
                s.getListaSenha().getListaSenha().add(s3);
            }
        }
        instance.addReparticao(rep);

        String hora = "9h30";
        Servico se = new Servico("A");

        List<Cidadao> listExp = new ArrayList<>();
        listExp.add(c1);
        listExp.add(c2);
        listExp.add(c3);

        Map<Servico, List<Cidadao>> mapRes = instance.getUtilizacaoRep(rep, hora);

        boolean expResult = true;
        boolean result = false;

        Iterator itr = listExp.iterator();
        for (Map.Entry<Servico, List<Cidadao>> entry : mapRes.entrySet()) {
            for (Cidadao cid : entry.getValue()) {
                Cidadao cidTemp = (Cidadao) itr.next();
                result = cidTemp.equals(cid);
            }
        }

        assertEquals(expResult, result);

    }

}
