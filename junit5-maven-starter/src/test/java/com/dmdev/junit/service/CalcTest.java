package com.dmdev.junit.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

public class CalcTest {

    @Test
    void testMin() {
        assertEquals(1, Calc._min(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testMax() {
        assertEquals(5, Calc._max(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testSum_1() {
        assertEquals(0, Calc._sum(new int[]{1000000000, 1000000000, 1000000000}));
    }

    @Test
    void testSum_2() {
        assertEquals(15, Calc._sum(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testMult_1() {
        assertEquals(0, Calc._mult(new int[]{100, 100, 100, 100, 100}));
    }

    @Test
    void testMult_2() {
        assertEquals(500, Calc._mult(new int[]{1, 1, 1, 5, 100}));
    }

    @Test
    void testOneNumInFile() {
        int[] numbers = {111};

        assertEquals(111, Calc._min(numbers));

        assertEquals(111, Calc._max(numbers));

        assertEquals(111, Calc._sum(numbers));

        assertEquals(111, Calc._mult(numbers));
    }
}
