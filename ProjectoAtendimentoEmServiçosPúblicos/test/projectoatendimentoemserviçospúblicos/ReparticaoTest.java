/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

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
public class ReparticaoTest {

    public ReparticaoTest() {
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
     * Test of getCidade method, of class Reparticao.
     */
    @Test
    public void testGetCidade() {
        System.out.println("getCidade");
        Reparticao instance = new Reparticao();
        String expResult = "";
        String result = instance.getCidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeroReparticao method, of class Reparticao.
     */
    @Test
    public void testGetNumeroReparticao() {
        System.out.println("getNumeroReparticao");
        Reparticao instance = new Reparticao();
        int expResult = 0;
        int result = instance.getNumeroReparticao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodigoPostal method, of class Reparticao.
     */
    @Test
    public void testGetCodigoPostal() {
        System.out.println("getCodigoPostal");
        Reparticao instance = new Reparticao();
        int expResult = 0;
        int result = instance.getCodigoPostal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaServicos method, of class Reparticao.
     */
    @Test
    public void testGetListaServicos() {
        System.out.println("getListaServicos");
        List<String> listServ = new ArrayList<>();
        listServ.add("a");
        listServ.add("b");
        Servico servA = new Servico ("a");
        Servico servB = new Servico ("b");
        Reparticao instance = new Reparticao("porto", 1111, 4490, listServ);
        List<Servico> expResult = new ArrayList<>();
        expResult.add(servA);
        expResult.add(servB);
        List<Servico> result = instance.getListaServicos().getListaServicos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCidadao method, of class Reparticao.
     */
    @Test
    public void testGetListaCidadao() {
        System.out.println("getListaCidadao");
        Cidadao cid = new Cidadao("teste", 999999999, "@", "4490-479", 1111);
        List<String> serv = new ArrayList<>();
        Reparticao instance = new Reparticao("porto", 1111, 4490, serv);
        instance.addCidadao(cid);
        
        ListaCidadao expResult = new ListaCidadao();
        expResult.getListaCidadao().addLast(cid);
        ListaCidadao result = instance.getListaCidadao();
        assertEquals(expResult.getListaCidadao(), result.getListaCidadao());
    }

    /**
     * Test of setCidade method, of class Reparticao.
     */
    @Test
    public void testSetCidade() {
        System.out.println("setCidade");
        String c = "";
        Reparticao instance = new Reparticao();
        instance.setCidade(c);
    }

    /**
     * Test of setNumeroReparticao method, of class Reparticao.
     */
    @Test
    public void testSetNumeroReparticao() {
        System.out.println("setNumeroReparticao");
        int n = 0;
        Reparticao instance = new Reparticao();
        instance.setNumeroReparticao(n);
    }

    /**
     * Test of setCodigoPostal method, of class Reparticao.
     */
    @Test
    public void testSetCodigoPostal() {
        System.out.println("setCodigoPostal");
        int n = 0;
        Reparticao instance = new Reparticao();
        instance.setCodigoPostal(n);
    }

    /**
     * Test of setListaServicos method, of class Reparticao.
     */
    @Test
    public void testSetListaServicos() {
        System.out.println("setListaServicos");
        List<String> s = new ArrayList<>();
        Reparticao instance = new Reparticao();
        instance.setListaServicos(s);
    }

    /**
     * Test of addCidadao method, of class Reparticao.
     */
    @Test
    public void testAddCidadao() {
        System.out.println("addCidadao");
        Cidadao cid = new Cidadao("teste", 999999999, "@", "4490-479", 1111);
        Reparticao instance = new Reparticao("porto", 1111, 4490, new ArrayList<>());
        instance.addCidadao(cid);
    }

    /**
     * Test of equals method, of class Reparticao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        List<String> serv = new ArrayList<>();
        Reparticao instance1 = new Reparticao("porto", 1111, 4490, serv);
        Reparticao instance2 = new Reparticao("braga", 2222, 4482, serv);
        boolean expResult = false;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }

}
