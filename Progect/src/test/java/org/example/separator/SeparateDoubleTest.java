package org.example.separator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateDoubleTest {
    @Test
    public void TestSeparateDoubleIsMatchNull(){
        String txt = null;
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertFalse(res);
        assertEquals(0.0, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatchEmpty(){
        String txt = "";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertFalse(res);
        assertEquals(0.0, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch1(){
        String txt = "1.73";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(1.73, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch2(){
        String txt = "-0.5";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(-0.5, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch3(){
        String txt = "+3.14E10";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(+3.14E10, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch4(){
        String txt = "2.71828e-5";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(2.71828e-5, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch5(){
        String txt = "1.0E0";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(1.0E0, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch6(){
        String txt = "123.";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertFalse(res);
        assertEquals(0.0, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch7(){
        String txt = ".456";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(.456, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch8(){
        String txt = "abc";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertFalse(res);
        assertEquals(0.0, separate.getValue(txt));
    }
    @Test
    public void TestSeparateDoubleIsMatch9(){
        String txt = "1.73E12";
        SeparateDouble separate = new SeparateDouble();

        boolean res = separate.isMatch(txt);

        assertTrue(res);
        assertEquals(1.73E12, separate.getValue(txt));
    }
}