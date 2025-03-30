package org.wesome.dsalgo;

import java.util.Objects;
import java.util.PriorityQueue;


public class MinCostRope {
    static int minCostRope(int[] arr) {
        if (Objects.isNull(arr)) {
            throw new NullPointerException("array is null");
        }
        int size = arr.length;
        /*  Create a priority queue pq to store the rope lengths.   */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            pq.add(arr[i]);
        }
        int result = 0;
        /*  Continue until only one element remains in the priority queue ie pq.size() > 1 */
        while (pq.size() > 1) {
            /*  Remove the two smallest rope lengths (ropeOne and roteTwo) from the priority queue using poll().    */
            int ropeOne = pq.poll();
            int roteTwo = pq.poll();
            /*  Calculate the combined length (combine) by adding ropeOne and roteTwo.  */
            int combine = ropeOne + roteTwo;
            /*  Update the result variable by adding the combined length (combine) to it.   */
            result = result + (combine);
            /*  Add the combined length back into the priority queue using add(combine).    */
            pq.add(combine);
        }
        return result;
    }
}