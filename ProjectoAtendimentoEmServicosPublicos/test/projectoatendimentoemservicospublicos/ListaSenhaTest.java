/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemservicospublicos;

import projectoatendimentoemservicospublicos.Servico;
import projectoatendimentoemservicospublicos.Senha;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class ListaSenhaTest {

    public ListaSenhaTest() {
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
     * Test of getListaSenha method, of class ListaSenha.
     */
    @Test
    public void testGetListaSenha() {
        System.out.println("getListaSenha");
        Senha se = new Senha(999999999, "a", 1);
        Senha s1 = new Senha(888888888, "a", 2);

        Servico instance = new Servico("a");
        instance.getListaSenha().getListaSenha().add(se);
        instance.getListaSenha().getListaSenha().add(s1);
        
        PriorityQueue<Senha> senhaList = new PriorityQueue<>();
        senhaList.add(se);
        senhaList.add(s1);
        
        boolean expResult = true;
        boolean result = false;
        Iterator itr = senhaList.iterator();
        for (Senha s : instance.getListaSenha().getListaSenha()) {
                Senha temp = (Senha) itr.next();
                result = temp.equals(s);
        }
        assertEquals(expResult, result);
    }

}
