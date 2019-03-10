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
public class DepositSlotTest {
    
    public DepositSlotTest() {
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
     * Test of isEnvelopeReceived method, of class DepositSlot.
     */
    @Test
    public void testIsEnvelopeReceived() {
        System.out.println("isEnvelopeReceived");
        DepositSlot instance = null;
        boolean expResult = false;
        boolean result = instance.isEnvelopeReceived();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDeposit method, of class DepositSlot.
     */
    @Test
    public void testAddDeposit() {
        System.out.println("addDeposit");
        int myAccount = 0;
        double amount = 0.0;
        DepositSlot instance = null;
        instance.addDeposit(myAccount, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateDeposit method, of class DepositSlot.
     */
    @Test
    public void testValidateDeposit() {
        System.out.println("validateDeposit");
        DepositSlot instance = null;
        instance.validateDeposit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
