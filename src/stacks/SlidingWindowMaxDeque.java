
// Java Program to find the maximum for
// each and every contiguous subarray of size K.

package stacks;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxDeque {
	
    // A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size K
	
    static void printMax(int arr[], int N, int K){
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> qi = new LinkedList<>();
        /* Process first k (or first window)
        elements of array */
        int i = 0;
        for(i = 0; i<K; ++i) {
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
        	while(!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) {
                // Remove from rear
        		qi.pollLast();
        	}
        	// Add new element at rear of queue
        	qi.offerLast(i);
        }
        
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        
        for(; i<N; ++i) {
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
        	System.out.println(arr[qi.peekFirst()]);
        	
            // Remove the elements which
            // are out of this window
        	while((!qi.isEmpty()) && qi.peek() <= i-K) {
        		qi.pollFirst();
        	}
        	
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
        	while((!qi.isEmpty() && arr[i] >= arr[qi.peekLast()])) {
                // Remove from rear
        		qi.pollLast();
        	}
        	// Add new element at rear of queue
        	qi.offerLast(i);
        }
        
        System.out.println(arr[qi.peek()]);
    }
    
    // Driver's code
    public static void main(String[] args)
    {
//        int arr[] = { 4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5 };
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int K = 3;
       
          // Function call
        printMax(arr, arr.length, K);
    }

}
