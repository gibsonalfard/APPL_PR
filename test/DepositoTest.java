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
public class DepositoTest {
    
    public DepositoTest() {
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
     * Test of displayMainMenu method, of class Deposito.
     */
    @Test
    public void testDisplayMainMenu() {
        System.out.println("displayMainMenu");
        Screen screen = null;
        Keypad keypad = null;
        Deposito instance = null;
        int expResult = 0;
        int result = instance.displayMainMenu(screen, keypad);
        assertEquals(expResult, result);
    }

    /**
     * Test of payTax method, of class Deposito.
     */
    @Test
    public void testPayTax() {
        System.out.println("payTax");
        Deposito instance = null;
        instance.payTax();
    }

    /**
     * Test of displayWithdrawalMenu method, of class Deposito.
     */
    @Test
    public void testDisplayWithdrawalMenu() {
        System.out.println("displayWithdrawalMenu");
        Deposito instance = null;
        int expResult = 0;
        int result = instance.displayWithdrawalMenu();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailableForWithdraw method, of class Deposito.
     */
    @Test
    public void testIsAvailableForWithdraw() {
        System.out.println("isAvailableForWithdraw");
        double amount = 0.0;
        Deposito instance = null;
        boolean expResult = false;
        boolean result = instance.isAvailableForWithdraw(amount);
        assertEquals(expResult, result);
    }
    
}
