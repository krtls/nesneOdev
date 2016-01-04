/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje;

import java.sql.PreparedStatement;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author beatles
 */
public class KelimeIT {
    
    public KelimeIT() {
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
     * Test of baglantiAc method, of class Kelime.
     */
    @Test
    public void testBaglantiAc_0args() throws Exception {
        System.out.println("baglantiAc");
        Kelime instance = new Kelime();
        Statement expResult = null;
        Statement result = instance.baglantiAc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of baglantiAc method, of class Kelime.
     */
    @Test
    public void testBaglantiAc_String() throws Exception {
        System.out.println("baglantiAc");
        String sql = "";
        Kelime instance = new Kelime();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.baglantiAc(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of baglantiKapat method, of class Kelime.
     */
    @Test
    public void testBaglantiKapat() throws Exception {
        System.out.println("baglantiKapat");
        Kelime instance = new Kelime();
        instance.baglantiKapat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kelime_ayir method, of class Kelime.
     */
    @Test
    public void testKelime_ayir() {
        System.out.println("kelime_ayir");
        String str = "";
        Kelime instance = new Kelime();
        instance.kelime_ayir(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gram_olustur method, of class Kelime.
     */
    @Test
    public void testGram_olustur() {
        System.out.println("gram_olustur");
        String str = "";
        Kelime instance = new Kelime();
        instance.gram_olustur(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kelime_ekle_temp method, of class Kelime.
     */
    @Test
    public void testKelime_ekle_temp() {
        System.out.println("kelime_ekle_temp");
        String kelime = "";
        Kelime instance = new Kelime();
        instance.kelime_ekle_temp(kelime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dizi_karsilastir method, of class Kelime.
     */
    @Test
    public void testDizi_karsilastir() {
        System.out.println("dizi_karsilastir");
        String[] arr1 = null;
        String[] arr2 = null;
        Kelime instance = new Kelime();
        int expResult = 0;
        int result = instance.dizi_karsilastir(arr1, arr2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Kelime.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Kelime.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
