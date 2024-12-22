package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateLongTest {

    @Test
    void SaparateLongisMathNull() {
        String txt = null;
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertFalse(res);
        assertEquals(0L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMathEmpty() {
        String txt = "";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertFalse(res);
        assertEquals(0L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMath1() {
        String txt = "276960";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertTrue(res);
        assertEquals(276960L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMath2() {
        String txt = "0";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertTrue(res);
        assertEquals(0L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMath3() {
        String txt = "8";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertTrue(res);
        assertEquals(8L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMath4() {
        String txt = "276968970870860860";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertTrue(res);
        assertEquals(276968970870860860L,separate.getValue(txt));
    }
    @Test
    void SaparateLongisMath5() {
        String txt = "-276960";
        SeparateLong separate = new SeparateLong();

        boolean res = separate.IsMath(txt);

        assertTrue(res);
        assertEquals(-276960L,separate.getValue(txt));
    }
}