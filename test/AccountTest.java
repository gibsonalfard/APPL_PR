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
         assertTrue("Login Gagal",bd.authenticateUser(1234, 4321));
         assertFalse("Login Sukses",bd.authenticateUser(1234, 42321));
     }
     
     @Test
     public void getBalance(){
         assertEquals("Balance Tidak Sesuai", 999.5, bd.getAvailableBalance(1234), 0.5);
     }
     
     public void afterWithdrawal(){
         bd.credit(6665, 200);
         assertEquals("AW : Balance Tidak sesuai",800.00, bd.getAvailableBalance(1234), 0);
         assertEquals("AW : Total Tidak sesuai",1000.00, bd.getTotalBalance(1234), 0);
     }
     
     @Test
     public void afterDeposit(){
         afterWithdrawal();
         bd.debit(6665, 20);
         
         assertEquals("AD : Total Tidak sesuai",1020.00, bd.getTotalBalance(1234), 0);
     }
     
//     @Test
//     public void MinusTax(){
//         afterWithdrawal();
//         bd.credit(6665, 20);
//         
//         assertEquals("AD : Total Tidak sesuai",1020.00, bd.getTotalBalance(1234), 0);
//     }
}
