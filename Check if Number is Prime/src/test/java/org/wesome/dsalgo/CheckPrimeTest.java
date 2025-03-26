package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPrimeTest {
    @Test
    void testPositivePrimeNumber() {
        // Test case: Positive prime number
        assertTrue(CheckPrime.checkPrime(23));
    }

    @Test
    void testNegativeNonPrimeNumber() {
        // Test case: Negative non-prime number
        assertFalse(CheckPrime.checkPrime(-4));
    }

    @Test
    void testZero() {
        // Test case: Zero
        assertFalse(CheckPrime.checkPrime(0));
    }

    @Test
    void testOne() {
        // Test case: One
        assertFalse(CheckPrime.checkPrime(1));
    }

    @Test
    void testTwo() {
        // Test case: Two (smallest prime number)
        assertTrue(CheckPrime.checkPrime(2));
    }

    @Test
    void testLargePrimeNumber() {
        // Test case: Large prime number
        assertTrue(CheckPrime.checkPrime(997));
    }

    @Test
    void testLargeNonPrimeNumber() {
        // Test case: Large non-prime number
        assertFalse(CheckPrime.checkPrime(1000));
    }

    @Test
    void testPerfectSquare() {
        // Test case: Perfect square (non-prime)
        assertFalse(CheckPrime.checkPrime(16));
    }

    @Test
    void testEvenNumberGreaterThanTwo() {
        // Test case: Even number greater than two (non-prime)
        assertFalse(CheckPrime.checkPrime(4));
    }

    @Test
    void testOddCompositeNumber() {
        // Test case: Odd composite number (non-prime)
        assertFalse(CheckPrime.checkPrime(15));
    }

    @Test
    void testIntegerMaxValue() {
        // Test case: Integer.MAX_VALUE = 2147483647
        assertTrue(CheckPrime.checkPrime(Integer.MAX_VALUE));
    }

    @Test
    void testIntegerMinValue() {
        // Test case: Integer.MIN_VALUE = -2147483648
        assertFalse(CheckPrime.checkPrime(Integer.MIN_VALUE));
    }

}