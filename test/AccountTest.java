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
 * @author m4nz2
 */
public class AccountTest {
    
    public AccountTest() {
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
     * Test of validatePIN method, of class Account.
     */
    @Test
    public void testValidatePIN() {
        System.out.println("validatePIN");
        int userPIN = 0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.validatePIN(userPIN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableBalance method, of class Account.
     */
    @Test
    public void testGetAvailableBalance() {
        System.out.println("getAvailableBalance");
        Account instance = null;
        double expResult = 0.0;
        double result = instance.getAvailableBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalBalance method, of class Account.
     */
    @Test
    public void testGetTotalBalance() {
        System.out.println("getTotalBalance");
        Account instance = null;
        double expResult = 0.0;
        double result = instance.getTotalBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transfer method, of class Account.
     */
    @Test
    public void testTransfer() {
        System.out.println("transfer");
        double amount = 0.0;
        Account instance = null;
        instance.transfer(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of credit method, of class Account.
     */
    @Test
    public void testCredit() {
        System.out.println("credit");
        double amount = 0.0;
        Account instance = null;
        instance.credit(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of debit method, of class Account.
     */
    @Test
    public void testDebit() {
        System.out.println("debit");
        double amount = 0.0;
        Account instance = null;
        instance.debit(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountNumber method, of class Account.
     */
    @Test
    public void testGetAccountNumber() {
        System.out.println("getAccountNumber");
        Account instance = null;
        int expResult = 0;
        int result = instance.getAccountNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePIN method, of class Account.
     */
    @Test
    public void testChangePIN() {
        System.out.println("changePIN");
        int thePIN = 0;
        Account instance = null;
        instance.changePIN(thePIN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blockUser method, of class Account.
     */
    @Test
    public void testBlockUser() {
        System.out.println("blockUser");
        Account instance = null;
        instance.blockUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unblockUser method, of class Account.
     */
    @Test
    public void testUnblockUser() {
        System.out.println("unblockUser");
        Account instance = null;
        instance.unblockUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUserBlocked method, of class Account.
     */
    @Test
    public void testIsUserBlocked() {
        System.out.println("isUserBlocked");
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.isUserBlocked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
