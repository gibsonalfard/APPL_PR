/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class ATMAppTest {
    
    public ATMAppTest() {
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
     * Test of main method, of class ATMApp.
     */
    
//    DINONAKTIFKAN SEMENTARA 
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        ATMApp.main(args);
//    }
    
//    AKTIFKAN JIKA INGIN MENGAMBIL INPUT DARI FILE INPUT.IN
    @Test
    public void testMain() throws IOException {
        System.out.println("main");
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("test/input.in"));
        System.setIn(fips);
        ATMApp.main(args);
        System.setIn(original);
    }
}
