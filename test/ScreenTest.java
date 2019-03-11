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
public class ScreenTest {
    
    public ScreenTest() {
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
     * Test of displayMessage method, of class Screen.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        String message = "";
        Screen instance = new Screen();
        instance.displayMessage(message);
    }

    /**
     * Test of displayMessageLine method, of class Screen.
     */
    @Test
    public void testDisplayMessageLine() {
        System.out.println("displayMessageLine");
        String message = "";
        Screen instance = new Screen();
        instance.displayMessageLine(message);
    }

    /**
     * Test of displayDollarAmount method, of class Screen.
     */
    @Test
    public void testDisplayDollarAmount() {
        System.out.println("displayDollarAmount");
        double amount = 0.0;
        Screen instance = new Screen();
        instance.displayDollarAmount(amount);
    }
    
}
