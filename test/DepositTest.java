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
public class DepositTest {
    
    public DepositTest() {
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
     * Test of execute method, of class Deposit.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Deposit instance = new Deposit(1234, new Screen(),new BankDatabase(), new Keypad(), new DepositSlot(1234, 4000, false));
        instance.execute();
    }
    
}
