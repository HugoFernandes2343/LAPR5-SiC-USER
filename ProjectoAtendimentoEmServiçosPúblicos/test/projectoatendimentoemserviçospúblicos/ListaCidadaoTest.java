/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import projectoatendimentoemservicospublicos.DoublyLinkedList;
import projectoatendimentoemservicospublicos.Reparticao;
import projectoatendimentoemservicospublicos.Cidadao;
import java.util.ArrayList;
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
public class ListaCidadaoTest {

    public ListaCidadaoTest() {
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
     * Test of getListaCidadao method, of class ListaCidadao.
     */
    @Test
    public void testGetListaCidadao() {
        System.out.println("getListaCidadao");
        Cidadao cid = new Cidadao("teste", 999999999, "@", "4490-479", 1111);
        Reparticao instance = new Reparticao("porto", 1111, 4490, new ArrayList<>());
        instance.addCidadao(cid);

        DoublyLinkedList<Cidadao> expResult = new DoublyLinkedList<>();
        expResult.addLast(cid);
        DoublyLinkedList<Cidadao> result = instance.getListaCidadao().getListaCidadao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCidadaoPorNumero method, of class ListaCidadao.
     */
    @Test
    public void testGetCidadaoPorNumero() {
        System.out.println("getCidadaoPorNumero");
        Cidadao cid = new Cidadao("teste", 999999999, "@", "4490-479", 1111);
        Reparticao instance = new Reparticao("porto", 1111, 4490, new ArrayList<>());
        instance.addCidadao(cid);

        Cidadao expResult = cid;
        Cidadao result = instance.getListaCidadao().getCidadaoPorNumero(999999999);
        assertEquals(expResult, result);
    }

}
