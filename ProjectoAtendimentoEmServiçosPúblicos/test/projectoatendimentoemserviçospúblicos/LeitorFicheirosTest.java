/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class LeitorFicheirosTest {

    public LeitorFicheirosTest() {
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
     * Test of LeitorFicheiros method, of class LeitorFicheiros.
     */
    @Test
    public void testLeitorFicheiros() throws Exception {
        System.out.println("LeitorFicheiros");
        LeitorFicheiros instance = new LeitorFicheiros();
        instance.LeitorFicheiros();
        
        
//        List<String> serv = new ArrayList<>();
//        serv.add("A");
//        serv.add("C");
//        serv.add("D");
//        Reparticao rep1 = new Reparticao("porto", 1234, 4200, serv);
//
//        boolean expResult = true;
//        boolean result = rep1.equals(instance.getListaReparticao().getReparticaoPorNumero(1234));
//        assertEquals(expResult, result);
//
//        Cidadao cid1 = new Cidadao("Ana", 111222333, "ana@gmail.com", "4200-072", 1234);
//        Cidadao cid2 = new Cidadao("Berta", 223344, "berta@gmail.com", "4200-071", 1234);
//        Cidadao cid3 = new Cidadao("Manuel", 584769, "manuel@gmail.com", "4215-357", 1230);
//        DoublyLinkedList<Cidadao> listCid = new DoublyLinkedList<>();
//        listCid.addLast(cid1);
//        listCid.addLast(cid2);
//        listCid.addLast(cid3);
//
//        DoublyLinkedList<Cidadao> cidTest = instance.getListaReparticao().getReparticaoPorNumero(1234).getListaCidadao().getListaCidadao();
//        boolean expRes = true;
//        boolean res = false;
//        Iterator itr = cidTest.iterator();
//        Iterator itr2 = listCid.iterator();
//        while (itr.hasNext()) {
//            Cidadao c = (Cidadao) itr.next();
//            Cidadao c2 = (Cidadao) itr2.next();
//            res = c.equals(c2);
//        }
//        assertEquals(expRes, res);
    }

}
