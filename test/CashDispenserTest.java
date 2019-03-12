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
public class CashDispenserTest {
    
    public CashDispenserTest() {
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
     * Test of dispenseCash method, of class CashDispenser.
     */
    @Test
    public void testDispenseCash() {
        System.out.println("dispenseCash");
        int amount = 0;
        CashDispenser instance = new CashDispenser();
        instance.dispenseCash(amount);
    }

    /**
     * Test of isSufficientCashAvailable method, of class CashDispenser.
     */
    @Test
    public void testIsSufficientCashAvailable() {
        System.out.println("isSufficientCashAvailable");
        int amount = 0;
        CashDispenser instance = new CashDispenser();
        boolean expResult = false;
        boolean result = instance.isSufficientCashAvailable(amount);
        assertEquals(expResult, result);
    }

    /**
     * Test of showCashDispenser method, of class CashDispenser.
     */
    @Test
    public void testShowCashDispenser() {
        System.out.println("showCashDispenser");
        CashDispenser instance = new CashDispenser();
        instance.showCashDispenser();
    }
    
}
