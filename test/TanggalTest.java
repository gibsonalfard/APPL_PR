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
public class TanggalTest {
    
    public TanggalTest() {
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
     * Test of tanggalSekarang method, of class Tanggal.
     */
    @Test
    public void testTanggalSekarang() {
        System.out.println("tanggalSekarang");
        Tanggal instance = new Tanggal();
        instance.tanggalSekarang();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTanggal method, of class Tanggal.
     */
    @Test
    public void testAddTanggal() {
        System.out.println("addTanggal");
        int tambahkanJumlahHari = 0;
        Tanggal instance = new Tanggal();
        instance.addTanggal(tambahkanJumlahHari);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTanggal method, of class Tanggal.
     */
    @Test
    public void testGetTanggal() {
        System.out.println("getTanggal");
        Tanggal instance = new Tanggal();
        int expResult = 0;
        int result = instance.getTanggal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuTanggal method, of class Tanggal.
     */
    @Test
    public void testMenuTanggal() {
        System.out.println("menuTanggal");
        Tanggal instance = new Tanggal();
        instance.menuTanggal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
