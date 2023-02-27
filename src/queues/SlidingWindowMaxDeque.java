package queues;

import com.sun.source.tree.BreakTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaxDeque {
    public static void main(String[] args) {
        int n = 11;
        int[] a = {4, 1, 3, 5,1,2,3,2,1,1,5};
        int[] a2 = {8, 7, 6, 9};
        int k = 3;
        int[] indices = maxElements(a, k);
        System.out.println(Arrays.toString(maxElements(a, k)));
        System.out.println(Arrays.toString(maxElements2(a2, 2)));
//        int[] ans = new int[indices.length];
//
//        for (int i = 0; i < indices.length; i++) {
//            ans[i] = a[indices[i]];
//        }
//        System.out.println(Arrays.toString(ans));
    }

    static int[] maxElements(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri] = a[q.peek()];
                ri++;
            }
        }
        return r;
    }

    static int[] maxElements2(int[] a, int k){
        if (a == null || k <= 0) {
            return new int[0];
        }

        Deque<Integer> q = new ArrayDeque<>();
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        for (int i = 0; i < n; i++) {
            //Remove elements out of window
            while(!q.isEmpty() && q.peekFirst() < i - k + 1){
                q.pollFirst();
            }
            //Remove smaller elements from the tail
            while (!q.isEmpty() && a[q.peekLast()] < a[i]){
                q.pollLast();
            }

            q.offer(i);

            if(i >= k-1){
                r[ri] = a[q.peek()];
                ri++;
            }
        }
        return r;
    }
}
