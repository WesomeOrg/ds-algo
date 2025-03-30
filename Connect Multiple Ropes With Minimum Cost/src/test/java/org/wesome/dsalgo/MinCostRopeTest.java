package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinCostRopeTest {

    @Test
    public void testEmptyArray() {
        // Test case: Empty array
        int[] arr = {};
        assertEquals(0, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testSingleElementArray() {
        // Test case: Single-element array
        int[] arr = {5};
        assertEquals(0, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testTwoElementArray() {
        // Test case: Two-element array
        int[] arr = {2, 3};
        assertEquals(5, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testMultipleElementArray() {
        // Test case: Multiple-element array
        int[] arr = {2, 3, 6, 8, 10, 13};
        assertEquals(100, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testDuplicateElementsArray() {
        // Test case: Array with duplicate elements
        int[] arr = {2, 2, 2, 2};
        assertEquals(16, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testNegativeNumbersArray() {
        // Test case: Array with negative numbers
        int[] arr = {-2, -3, -6, -8, -10, -13};
        assertEquals(-173, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testLargeNumbersArray() {
        // Test case: Array with large numbers
        int[] arr = {1000000, 2000000, 3000000, 4000000, 5000000};
        assertEquals(33000000, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testNullArray() {
        // Test case: Null array
        assertThrows(NullPointerException.class, () -> MinCostRope.minCostRope(null));
    }
}