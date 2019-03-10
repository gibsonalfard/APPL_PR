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
 * @author Gibran
 */
public class AccountTest {
    BankDatabase bd;
    
    public AccountTest() {
        bd = new BankDatabase();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void LoginAccount() {
         assert(bd.authenticateUser(1234, 4321));
         assert(bd.authenticateUser(8765, 5678));
         assert(bd.authenticateUser(00000, 00000));
         assert(bd.authenticateUser(12345, 54321) == false);
         assert(bd.authenticateUser(87612312, 51231236) == false);
         assert(bd.authenticateUser(-87612312, -51231236) == false);
         assert(bd.authenticateUser(-0, -1) == false);
//         assert(bd.authenticateUser(-0, -0) == false); //EROR
//         assertTrue("Login Gagal",bd.authenticateUser(1234, 4321));
//         assertFalse("Login Sukses",bd.authenticateUser(1234, 42321));
     }
     
     @Test
     public void getBalance(){
         assert(bd.getAvailableBalance(1234) == 1000.0);
         assert(bd.getAvailableBalance(8765) == 200.0);
         assert(bd.getAvailableBalance(00000) == 200.0);
         System.out.println(bd.getAvailableBalance(12345));
         assert(bd.getAvailableBalance(12345) == 0.0);
//           assert.assertNull(bd.getAvailableBalance(12345));
//         assert(bd.getAvailableBalance(12345) == 0.0);
//         assert(bd.getAvailableBalance(-10) = 0.0);
         
         
//         assertEquals("Balance Tidak Sesuai", 999.5, bd.getAvailableBalance(1234), 0.5);
     }
     
     public void afterWithdrawal(){
         bd.credit(1234, 200);
         assertEquals("AW : Balance Tidak sesuai",800.00, bd.getAvailableBalance(1234), 0);
         assertEquals("AW : Total Tidak sesuai",1000.00, bd.getTotalBalance(1234), 0);
     }
     
     @Test
     public void afterDeposit(){
         afterWithdrawal();
         bd.debit(1234, 20);
         assertEquals("AD : Total Tidak sesuai",1020.00, bd.getTotalBalance(1234), 0);
     }
     
     
}
