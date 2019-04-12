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
public class TransactionTest {
    
    public TransactionTest() {
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
     * Test of getAccountNumber method, of class Transaction.
     */
    @Test
    public void testGetAccountNumber() {
        System.out.println("getAccountNumber");
        Transaction instance = null;
        int expResult = 0;
        int result = instance.getAccountNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScreen method, of class Transaction.
     */
    @Test
    public void testGetScreen() {
        System.out.println("getScreen");
        Transaction instance = null;
        Screen expResult = new Screen();
        Screen result = instance.getScreen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBankDatabase method, of class Transaction.
     */
    @Test
    public void testGetBankDatabase() {
        System.out.println("getBankDatabase");
        Transaction instance = null;
        BankDatabase expResult = new BankDatabase();
        BankDatabase result = instance.getBankDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class Transaction.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Transaction instance = null;
        instance.execute();
    }

    public class TransactionImpl extends Transaction {

        public TransactionImpl() {
            super(0, null, null);
        }

        public void execute() {
        }
    }
    
}
