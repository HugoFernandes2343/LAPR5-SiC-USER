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
 * @author Norberto Sousa
 */
public class ListaServicosTest {

    public ListaServicosTest() {
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
     * Test of getListaServicos method, of class ListaServicos.
     */
    @Test
    public void testGetListaServicos() {
        System.out.println("getListaServicos");
        List<String> servList = new ArrayList<>();
        servList.add("a");
        Servico serv = new Servico("a");
        Reparticao instance = new Reparticao("porto", 1111, 4490, servList);
        List<Servico> expResult = new ArrayList<>();
        expResult.add(serv);
        List<Servico> result = instance.getListaServicos().getListaServicos();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkForServ method, of class ListaServicos.
     */
    @Test
    public void testCheckForServ() {
        System.out.println("checkForServ");

        List<String> servList = new ArrayList<>();
        servList.add("a");
        servList.add("b");
        Reparticao instance = new Reparticao("porto", 1111, 4490, servList);

        Servico serv = new Servico("b");
        boolean expResult = true;
        boolean result = instance.getListaServicos().checkForServ(serv);
        assertEquals(expResult, result);
    }

}
