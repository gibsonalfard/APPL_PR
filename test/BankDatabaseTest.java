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
public class BankDatabaseTest {
    
    public BankDatabaseTest() {
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
     * Test of getSpecificAccount method, of class BankDatabase.
     */
    @Test
    public void testGetSpecificAccount() {
        System.out.println("getSpecificAccount");
        
        //1. NOT NULL EXPECTED
        int userAccountNumber = 1234;
        int userPIN = 4321;
        BankDatabase instance = new BankDatabase();
        Account expResult = null;
        Account result = instance.getSpecificAccount(userAccountNumber, userPIN);
        assert(expResult != result);
        
        //2. NULL EXPECTED
        userAccountNumber = -0;
        userPIN = -0;
        result = instance.getSpecificAccount(userAccountNumber, userPIN);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAvail method, of class BankDatabase.
     */
    @Test
    public void testCheckAvail() {
        System.out.println("checkAvail");
        int accountNumber = 0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.checkAvail(accountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authenticateAdmin method, of class BankDatabase.
     */
    @Test
    public void testAuthenticateAdmin() {
        System.out.println("authenticateAdmin");
        int userAccountNumber = 0;
        int userPIN = 0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.authenticateAdmin(userAccountNumber, userPIN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authenticateUser method, of class BankDatabase.
     */
    @Test
    public void testAuthenticateUser() {
        System.out.println("authenticateUser");
        int userAccountNumber = 0;
        int userPIN = 0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.authenticateUser(userAccountNumber, userPIN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seekAccountNumber method, of class BankDatabase.
     */
    @Test
    public void testSeekAccountNumber() {
        System.out.println("seekAccountNumber");
        int accountNumber = 0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.seekAccountNumber(accountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableBalance method, of class BankDatabase.
     */
    @Test
    public void testGetAvailableBalance() {
        System.out.println("getAvailableBalance");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        double expResult = 0.0;
        double result = instance.getAvailableBalance(userAccountNumber);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalBalance method, of class BankDatabase.
     */
    @Test
    public void testGetTotalBalance() {
        System.out.println("getTotalBalance");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        double expResult = 0.0;
        double result = instance.getTotalBalance(userAccountNumber);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transfer method, of class BankDatabase.
     */
    @Test
    public void testTransfer() {
        System.out.println("transfer");
        int userAccountNumber = 0;
        double amount = 0.0;
        BankDatabase instance = new BankDatabase();
        instance.transfer(userAccountNumber, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of credit method, of class BankDatabase.
     */
    @Test
    public void testCredit() {
        System.out.println("credit");
        int userAccountNumber = 0;
        double amount = 0.0;
        BankDatabase instance = new BankDatabase();
        instance.credit(userAccountNumber, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of debit method, of class BankDatabase.
     */
    @Test
    public void testDebit() {
        System.out.println("debit");
        int userAccountNumber = 0;
        double amount = 0.0;
        BankDatabase instance = new BankDatabase();
        instance.debit(userAccountNumber, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeAccountPIN method, of class BankDatabase.
     */
    @Test
    public void testChangeAccountPIN() {
        System.out.println("changeAccountPIN");
        int userAccountNumber = 0;
        int curPIN = 0;
        int newPIN = 0;
        BankDatabase instance = new BankDatabase();
        instance.changeAccountPIN(userAccountNumber, curPIN, newPIN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blockAccount method, of class BankDatabase.
     */
    @Test
    public void testBlockAccount() {
        System.out.println("blockAccount");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        instance.blockAccount(userAccountNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unblockAccount method, of class BankDatabase.
     */
    @Test
    public void testUnblockAccount() {
        System.out.println("unblockAccount");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        instance.unblockAccount(userAccountNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAccountBlocked method, of class BankDatabase.
     */
    @Test
    public void testIsAccountBlocked() {
        System.out.println("isAccountBlocked");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.isAccountBlocked(userAccountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUserExist method, of class BankDatabase.
     */
    @Test
    public void testIsUserExist() {
        System.out.println("isUserExist");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.isUserExist(userAccountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incAccount method, of class BankDatabase.
     */
    @Test
    public void testIncAccount() {
        System.out.println("incAccount");
        int theAccountNumber = 0;
        int thePIN = 0;
        double theAvailableBalance = 0.0;
        double theTotalBalance = 0.0;
        BankDatabase instance = new BankDatabase();
        instance.incAccount(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransferToday method, of class BankDatabase.
     */
    @Test
    public void testGetTransferToday() {
        System.out.println("getTransferToday");
        int theAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        double expResult = 0.0;
        double result = instance.getTransferToday(theAccountNumber);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWithdrawalToday method, of class BankDatabase.
     */
    @Test
    public void testGetWithdrawalToday() {
        System.out.println("getWithdrawalToday");
        int theAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        double expResult = 0.0;
        double result = instance.getWithdrawalToday(theAccountNumber);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAvailableWithdraw method, of class BankDatabase.
     */
    @Test
    public void testIsAvailableWithdraw() {
        System.out.println("isAvailableWithdraw");
        int theAccountNumber = 0;
        double amount = 0.0;
        BankDatabase instance = new BankDatabase();
        boolean expResult = false;
        boolean result = instance.isAvailableWithdraw(theAccountNumber, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of monthlyTax method, of class BankDatabase.
     */
    @Test
    public void testMonthlyTax() {
        System.out.println("monthlyTax");
        BankDatabase instance = new BankDatabase();
        instance.monthlyTax();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWithdrawal method, of class BankDatabase.
     */
    @Test
    public void testGetWithdrawal() {
        System.out.println("getWithdrawal");
        int userAccountNumber = 0;
        BankDatabase instance = new BankDatabase();
        int expResult = 0;
        int result = instance.getWithdrawal(userAccountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetLimit method, of class BankDatabase.
     */
    @Test
    public void testResetLimit() {
        System.out.println("resetLimit");
        BankDatabase instance = new BankDatabase();
        instance.resetLimit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
