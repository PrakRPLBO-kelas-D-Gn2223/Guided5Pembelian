package com.rplbo.pembelian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testBarangBiasa(){
        Pembelian p1 = new Pembelian();
        p1.setNama_barang("Buku");
        p1.setHarga(1000);
        p1.setJumlah(3);
        p1.setPajak(10);
        p1.setMewah(false);
        assertEquals("Buku",p1.getNama_barang());
        assertEquals(1000.0,p1.getHarga());
        assertEquals(3,p1.getJumlah());
        assertEquals(10.0,p1.getPajak());
        assertFalse(p1.isMewah());
        p1.bayar();
        String expected = "Total: Rp. 3300.0";
        assertEquals(expected,outputStreamCaptor.toString().trim());
    }

    @Test
    public void testBarangMewah(){
        Pembelian p2 = new Pembelian();
        p2.setNama_barang("Mobil");
        p2.setHarga(1000000);
        p2.setJumlah(1);
        p2.setPajak(10);
        p2.setMewah(true);
        assertEquals("Mobil",p2.getNama_barang());
        assertEquals(1000000.0,p2.getHarga());
        assertEquals(1,p2.getJumlah());
        assertEquals(10.0,p2.getPajak());
        assertTrue(p2.isMewah());
        p2.bayar();
        String expected = "Total: Rp. 1122000.0";
        assertEquals(expected,outputStreamCaptor.toString().trim());
    }
}
