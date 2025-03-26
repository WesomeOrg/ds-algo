package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(42, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testDuplicateElementsArray() {
        // Test case: Array with duplicate elements
        int[] arr = {2, 2, 2, 2};
        assertEquals(12, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testNegativeNumbersArray() {
        // Test case: Array with negative numbers
        int[] arr = {-2, -3, -6, -8, -10, -13};
        assertEquals(-42, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testLargeNumbersArray() {
        // Test case: Array with large numbers
        int[] arr = {1000000, 2000000, 3000000, 4000000, 5000000};
        assertEquals(15000000, MinCostRope.minCostRope(arr));
    }

    @Test
    public void testNullArray() {
        // Test case: Null array
        try {
            MinCostRope.minCostRope(null);
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
    }


}