package stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class StackQuestions {
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 20, 15, 3, 12};
        int[] arr2 = {3, 10, 5, 1, 15, 10, 7, 6};
        int[] arr3 = {4, 2, 1, 5, 6, 3, 2, 4, 2};
        int[] arr4 = {3, 1, 2, 4};
        int [][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};

//        System.out.println(Arrays.toString(previousSmallerElement(arr)));
//        System.out.println(Arrays.toString(previousSmallerElementIndices(arr)));
//        System.out.println(Arrays.toString(previousGreaterElement(arr)));
//        System.out.println(Arrays.toString(nextSmallerElement(arr2)));
//        System.out.println(Arrays.toString(nextSmallerElementIndices(arr2)));
//        System.out.println(Arrays.toString(nextGreaterElement(arr2)));
        System.out.println(maxAreaInAHistogram(arr3));
        System.out.println(maximalRectangle(matrix));
    }

    public static int[] previousSmallerElement(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!st.isEmpty() && arr[i] <= st.peek()) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);

        }
        return res;
    }

    public static int[]previousSmallerElementIndices(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(i);

        }
        return res;
    }

    public static int[] previousGreaterElement(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);

        }
        return res;
    }

    public static int[] nextSmallerElement(int[] arr){
        int len = arr.length;
        int[] res = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = len-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= st.peek()){
                st.pop();
            }

            if(st.size() == 0){
                res[i] = -1;
            }
            else {
                res[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return res;
    }

    public static int[] nextSmallerElementIndices(int[] arr){
        int len = arr.length;
        int[] res = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = len-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                res[i] = len;
            }
            else {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    public static int[] nextGreaterElement(int[] arr){
        int len = arr.length;
        int[] res = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = len-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }

            if(st.size() == 0){
                res[i] = -1;
            }
            else {
                res[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return res;
    }

    public static int maxAreaInAHistogram(int[] arr){
        int[] pse = previousSmallerElementIndices(arr);
        int[] nse = nextSmallerElementIndices(arr);

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = (nse[i] - pse[i] - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int maximalRectangle(int [][] arr){
        int[] heights = arr[0];
        int maxArea = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    heights[j] += 1;
                }
                else {
                    heights[j] = 0;
                }
            }

            int curArea = maxAreaInAHistogram(heights);
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }

}
