/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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
public class ServicoTest {

    public ServicoTest() {
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
     * Test of getListaSenha method, of class Servico.
     */
    @Test
    public void testGetListaSenha() {
        System.out.println("getListaSenha");
        
        Servico instance = new Servico("a");
        Senha s1 = new Senha(999999999, "a", 1);
        Senha s2 = new Senha(888888888, "a", 2);
        Senha s3 = new Senha(777777777, "a", 3);
        instance.getListaSenha().getListaSenha().add(s1);
        instance.getListaSenha().getListaSenha().add(s2);
        instance.getListaSenha().getListaSenha().add(s3);
        PriorityQueue<Senha> senhaList = new PriorityQueue<>();
        senhaList.add(s1);
        senhaList.add(s2);
        senhaList.add(s3);
        boolean expResult = true;
        boolean result = false;
        Iterator itr = senhaList.iterator();
        for (Senha s : senhaList) {
                Senha temp = (Senha) itr.next();
                result = temp.equals(s);
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of getLetraCodigo method, of class Servico.
     */
    @Test
    public void testGetLetraCodigo() {
        System.out.println("getLetraCodigo");
        Servico instance = new Servico("A");
        String expResult = "A";
        String result = instance.getLetraCodigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Servico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Servico instance1 = new Servico("a");
        Servico instance2 = new Servico("b");
        boolean expResult = false;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkSenhasDoCidadao method, of class Servico.
     */
    @Test
    public void testCheckSenhasDoCidadao() {
        System.out.println("checkSenhasDoCidadao");
        List<String> servR1 = new ArrayList<>();
        List<String> servR2 = new ArrayList<>();
        servR1.add("A");
        servR1.add("B");
        servR2.add("A");
        servR2.add("B");
        servR2.add("C");
        Reparticao r1 = new Reparticao("Maia", 1235, 4470,servR1);
        Cidadao c1 = new Cidadao("Ana", 111222333, "ana@gmail.com", "4200-072", 1235);
        r1.addCidadao(c1);
        Senha s1 = new Senha(111222333,"A",1);
        Senha s2 = new Senha(333222111,"A",2);
        Servico instance= r1.getListaServicos().getListaServicos().get(0);
        instance.getListaSenha().getListaSenha().add(s1);
        instance.getListaSenha().getListaSenha().add(s2);
        boolean expResult = true;
        boolean result = instance.CheckSenhasDoCidadao(c1);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeSenhaDoCidadao method, of class Servico.
     */
    @Test
    public void testRemoveSenhaDoCidadao() {
        System.out.println("removeSenhaDoCidadao");
        List<String> servR1 = new ArrayList<>();
        servR1.add("A");
        servR1.add("B");
        Reparticao r1 = new Reparticao("Maia", 1235, 4470,servR1);
        Cidadao c1 = new Cidadao("Ana", 111222333, "ana@gmail.com", "4200-072", 1235);
        r1.addCidadao(c1);
        Senha s1 = new Senha(111222333,"A",1);
        Senha s2 = new Senha(333222111,"A",2);
        Servico instance= r1.getListaServicos().getListaServicos().get(0);
        instance.getListaSenha().getListaSenha().add(s1);
        instance.getListaSenha().getListaSenha().add(s2);
        instance.removeSenhaDoCidadao(c1);
        boolean expResult = false;
        boolean result = instance.getListaSenha().getListaSenha().peek().getNumeroContribuinte() == 111222333;
        assertEquals(expResult,result);
    }
}
