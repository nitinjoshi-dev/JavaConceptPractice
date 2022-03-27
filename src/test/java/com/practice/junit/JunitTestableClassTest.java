package com.practice.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class JunitTestableClassTest {

    @DisplayName("Find max test case with null input")
    @Test
    public void testFindMax() {
        assertEquals(Integer.MIN_VALUE, JunitTestableClass.findMax(null));
    }

    @DisplayName("Find max test case with negative numbers")
    @Test
    public void testFindMaxWithNegativeNumbers() {
        assertEquals(-1, JunitTestableClass.findMax(new int[]{-12,-1,-3,-4,-2}));
    }

    @DisplayName("Find max test case with positive numbers")
    @Test
    public void testFindMaxWithPositiveNumbers() {
        assertEquals(12, JunitTestableClass.findMax(new int[]{12,1,3,4,2}));
    }

    @DisplayName("Find max test case with mixed numbers")
    @Test
    public void testFindMaxWithMixedNumbers() {
        assertEquals(3, JunitTestableClass.findMax(new int[]{-12,-1,3,-4,2}));
    }

    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.");
    }

}