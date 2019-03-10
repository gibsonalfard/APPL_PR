/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmadajinaufalali
 */
public class ATMTest {
    
    public ATMTest() {
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
     * Test of run method, of class ATM.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ATM instance = new ATM();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showUnblockMenu method, of class ATM.
     */
    @Test
    public void testShowUnblockMenu() {
        System.out.println("showUnblockMenu");
        Keypad keypad = null;
        BankDatabase bankDatabase = null;
        Screen screen = null;
        ATM instance = new ATM();
        instance.showUnblockMenu(keypad, bankDatabase, screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
