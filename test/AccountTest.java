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
    }

    /**
     * Test of setAvailableBalance method, of class Account.
     */
    @Test
    public void testSetAvailableBalance() {
        System.out.println("setAvailableBalance");
        double amount = 0.0;
        Account instance = null;
        instance.setAvailableBalance(amount);
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
    }

    /**
     * Test of blockUser method, of class Account.
     */
    @Test
    public void testBlockUser() {
        System.out.println("blockUser");
        Account instance = null;
        instance.blockUser();
    }

    /**
     * Test of unblockUser method, of class Account.
     */
    @Test
    public void testUnblockUser() {
        System.out.println("unblockUser");
        Account instance = null;
        instance.unblockUser();
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
    }

    /**
     * Test of getAccountType method, of class Account.
     */
    @Test
    public void testGetAccountType() {
        System.out.println("getAccountType");
        Account instance = null;
        String expResult = "";
        String result = instance.getAccountType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTransferToday method, of class Account.
     */
    @Test
    public void testGetTransferToday() {
        System.out.println("getTransferToday");
        Account instance = null;
        int expResult = 0;
        int result = instance.getTransferToday();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTransferToday method, of class Account.
     */
    @Test
    public void testSetTransferToday() {
        System.out.println("setTransferToday");
        double transferToday = 0.0;
        Account instance = null;
        instance.setTransferToday(transferToday);
    }

    /**
     * Test of getWithdrawToday method, of class Account.
     */
    @Test
    public void testGetWithdrawToday() {
        System.out.println("getWithdrawToday");
        Account instance = null;
        int expResult = 0;
        int result = instance.getWithdrawToday();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWithdrawToday method, of class Account.
     */
    @Test
    public void testSetWithdrawToday() {
        System.out.println("setWithdrawToday");
        double WithdrawToday = 0.0;
        Account instance = null;
        instance.setWithdrawToday(WithdrawToday);
    }

    /**
     * Test of displayWithdrawalMenu method, of class Account.
     */
    @Test
    public void testDisplayWithdrawalMenu() {
        System.out.println("displayWithdrawalMenu");
        Account instance = null;
        int expResult = 0;
        int result = instance.displayWithdrawalMenu();
        assertEquals(expResult, result);
    }

    /**
     * Test of displayMainMenu method, of class Account.
     */
    @Test
    public void testDisplayMainMenu() {
        System.out.println("displayMainMenu");
        Screen screen = null;
        Keypad keypad = null;
        Account instance = null;
        int expResult = 0;
        int result = instance.displayMainMenu(screen, keypad);
        assertEquals(expResult, result);
    }

    /**
     * Test of payTax method, of class Account.
     */
    @Test
    public void testPayTax() {
        System.out.println("payTax");
        Account instance = null;
        instance.payTax();
    }

    /**
     * Test of isAvailableForWithdraw method, of class Account.
     */
    @Test
    public void testIsAvailableForWithdraw() {
        System.out.println("isAvailableForWithdraw");
        double amount = 0.0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.isAvailableForWithdraw(amount);
        assertEquals(expResult, result);
    }
    
}
