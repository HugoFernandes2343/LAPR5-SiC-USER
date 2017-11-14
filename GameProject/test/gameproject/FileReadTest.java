/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

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
public class FileReadTest {
    
    public FileReadTest() {
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
     * Test of getGameBase method, of class FileRead.
     */
    @Test
    public void testGetGameBase() {
        System.out.println("getGameBase");
        FileRead instance = new FileRead();
        GameBase expResult = null;
        GameBase result = instance.getGameBase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FileRead method, of class FileRead.
     */
    @Test
    public void testFileRead() throws Exception {
        System.out.println("FileRead");
        FileRead instance = new FileRead();
        instance.FileRead();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
