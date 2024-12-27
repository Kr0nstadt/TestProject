package org.example.separator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateLongTest {

    @Test
    void SaparateLongisMatchNull() {
        String txt = null;
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertFalse(res);
        assertEquals(0L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMatchEmpty() {
        String txt = "";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertFalse(res);
        assertEquals(0L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMatch1() {
        String txt = "276960";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(276960L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMatch2() {
        String txt = "0";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(0L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMatch3() {
        String txt = "8";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(8L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMatch4() {
        String txt = "276968970870860860";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(276968970870860860L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMatch5() {
        String txt = "-276960";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(-276960L,separate.getValue(txt));
    }
}