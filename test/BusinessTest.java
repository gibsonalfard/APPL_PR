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
public class BusinessTest {
    
    public BusinessTest() {
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
     * Test of displayMainMenu method, of class Business.
     */
    @Test
    public void testDisplayMainMenu() {
        System.out.println("displayMainMenu");
        Screen screen = new Screen();
        Keypad keypad = new Keypad();
        Business instance = new Business(1234, 4321, 1000.0, 1200.0);;
        int expResult = 0;
        int result = instance.displayMainMenu(screen, keypad);
        assertEquals(expResult, result);
    }

    /**
     * Test of payTax method, of class Business.
     */
    @Test
    public void testPayTax() {
        System.out.println("payTax");
        Business instance = new Business(1234, 4321, 1000.0, 1200.0);
        instance.payTax();
    }

    /**
     * Test of displayWithdrawalMenu method, of class Business.
     */
    @Test
    public void testDisplayWithdrawalMenu() {
        System.out.println("displayWithdrawalMenu");
        Business instance = new Business(1234, 4321, 1000.0, 1200.0);
        int expResult = 0;
        int result = instance.displayWithdrawalMenu();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailableForWithdraw method, of class Business.
     */
    @Test
    public void testIsAvailableForWithdraw() {
        System.out.println("isAvailableForWithdraw");
        double amount = 0.0;
        Business instance = new Business(1234, 4321, 1000.0, 1200.0);
        boolean expResult = false;
        boolean result = instance.isAvailableForWithdraw(amount);
        assertEquals(expResult, result);
    }
    
}
