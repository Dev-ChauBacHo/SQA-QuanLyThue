package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.BillDao;

public class BillDaoTinhThueTest {
    private BillDao tinhThue = new BillDao();
//    private Object NumberFormat;

    @Test
    public void tinhTienThue() {
        assertEquals(0, tinhThue.tinhTienThue(10000000, 2));
    }

    @Test
    public void tinhTienThue_SoAm() {
//        assertEquals(0, tinhThue.TinhTienThue(-10000000, 0));
        assertThrows(NumberFormatException.class, () -> {
        tinhThue.tinhTienThue(-1, 0);
        });
    }

    @Test
    public void tinhTienThue_Bac1_1() {
        assertEquals(0, tinhThue.tinhTienThue(11000000, 2));
    }

    @Test
    public void tinhTienThue_Bac1_2() {
        assertEquals(0, tinhThue.tinhTienThue(11000001, 0));
    }

    @Test
    public void tinhTienThue_Bac1_3() {
        assertEquals(0, tinhThue.tinhTienThue(10000000, 1));
    }

    @Test
    public void tinhTienThue_Bac1_4() {
        assertEquals(30000, tinhThue.tinhTienThue(16000001, 1));
    }

    @Test
    public void tinhTienThue_Bac2_1() {
        assertEquals(250000, tinhThue.tinhTienThue(16000001, 0));
    }

    @Test
    public void tinhTienThue_Bac2_2() {
        assertEquals(750000, tinhThue.tinhTienThue(21000000, 0));
    }

    @Test
    public void tinhTienThue_Bac2_3() {
        assertEquals(310000, tinhThue.tinhTienThue(21000001, 1));
    }

    @Test
    public void tinhTienThue_Bac3_1() {
        assertEquals(750000, tinhThue.tinhTienThue(21000001, 0));
    }

    @Test
    public void tinhTienThue_Bac3_2() {
        assertEquals(1950000, tinhThue.tinhTienThue(29000000, 0));
    }

    @Test
    public  void tinhTienThue_Bac3_3() {
        assertEquals(1290000, tinhThue.tinhTienThue(29000001, 1));
    }

    @Test
    public void tinhTienThue_Bac4_1() {
        assertEquals(1950000, tinhThue.tinhTienThue(29000001, 0));
    }

    @Test
    public void tinhTienThue_Bac4_2() {
        assertEquals(4750000, tinhThue.tinhTienThue(43000000, 0));
    }

    @Test
    public void tinhTienThue_Bac4_3() {
        assertEquals(3870000, tinhThue.tinhTienThue(43000001, 1));
    }

    @Test
    public void tinhTienThue_Bac5_1() {
        assertEquals(4750000, tinhThue.tinhTienThue(43000001, 0));
    }

    @Test
    public void tinhTienThue_Bac5_2() {
        assertEquals(9750000, tinhThue.tinhTienThue(63000000, 0));
    }

    @Test
    public void tinhTienThue_Bac5_3() {
        assertEquals(8650000, tinhThue.tinhTienThue(63000001, 1));
    }

    @Test
    public void tinhTienThue_Bac6_1() {
        assertEquals(9750000, tinhThue.tinhTienThue(63000001, 0));
    }

    @Test
    public void tinhTienThue_Bac6_2() {
        assertEquals(18150000, tinhThue.tinhTienThue(91000000, 0));
    }

    @Test
    public void tinhTienThue_Bac6_3() {
        assertEquals(16830000, tinhThue.tinhTienThue(91000001, 1));
    }

    @Test
    public void tinhTienThue_Bac7_1() {
        assertEquals(18150000, tinhThue.tinhTienThue(91000001, 0));
    }

    @Test
    public  void tinhTienThue_Bac7_2() {
        assertEquals(21300000, tinhThue.tinhTienThue(100000000, 0));
    }

}
