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
public class AccountTest_edit {
    BankDatabase bd;
    
    public AccountTest_edit() {
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
         assertTrue("authenticateUser(1234, 4321) "
                 + "GAGAL-SEHARUSNYA BERHASIL",bd.authenticateUser(1234, 4321));
         assertTrue("authenticateUser(8765, 5678) "
                 + "GAGAL-SEHARUSNYA BERHASIL",bd.authenticateUser(8765, 5678));
         assertTrue("authenticateUser(00000, 00000) "
                 + "GAGAL-SEHARUSNYA BERHASIL",bd.authenticateUser(00000, 00000));
         assertFalse("authenticateUser(12345, 54321) "
                 + "BERHASIL-SEHARUSNYA GAGAL",bd.authenticateUser(12345, 54321));
         assertFalse("authenticateUser(-1234, 4321) "
                 + "BERHASIL-SEHARUSNYA GAGAL",bd.authenticateUser(1234543, 4321));
         assertFalse("authenticateUser(0, 0) "
                 + "BERHASIL-SEHARUSNYA GAGAL",bd.authenticateUser(0, 0));
         
     }
     
     @Test
     public void getBalance(){
         assertEquals("AW : Balance Tidak sesuai",100.00, bd.getAvailableBalance(1234), 0);
//         assert(bd.getAvailableBalance(1234) == 1000.0);
//         assert(bd.getAvailableBalance(8765) == 200.0);
//         assert(bd.getAvailableBalance(00000) == 200.0);
//         assert(bd.getAvailableBalance(12345) == 0.0);
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
     
     @Test
     public void MinusTax(){
         afterWithdrawal();
         bd.credit(6665, 20);
         assertEquals("AD : Total Tidak sesuai",1020.00, bd.getTotalBalance(1234), 0);
     }
}
