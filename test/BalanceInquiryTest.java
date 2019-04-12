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
public class BalanceInquiryTest {
    
    public BalanceInquiryTest() {
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
     * Test of execute method, of class BalanceInquiry.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        BalanceInquiry instance = new BalanceInquiry(1234, new Screen(), new BankDatabase());
        instance.execute();
    }
    
}
