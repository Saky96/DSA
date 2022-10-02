package stacks;

/*
Next Greater Element To The Right
Medium

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.

"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementToRight {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr){

        int arrLen = arr.length;
        int[] ans = new int[arrLen];
        Stack<Integer> st = new Stack<>();

        ans[arrLen - 1] = -1;
        st.push(arr[arrLen - 1]);

        for (int i = arrLen - 2; i >= 0; i--) {
//            if(st.empty()){
//                ans[i] = -1;
//                st.push(arr[i]);
//            }
//            else if(st.peek() <= arr[i]){
//                while(!st.empty() && arr[i] >= st.peek()){
//                    st.pop();
//                }
//                if(st.empty()){
//                    ans[i] = -1;
//                    st.push(arr[i]);
//                }
//                else {
//                    ans[i] = st.peek();
//                    st.push(arr[i]);
//                }
//            } else if (st.peek() > arr[i]) {
//                ans[i] = st.peek();
//                st.push(arr[i]);
//            }
            while (st.size() > 0 && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return ans;
    }
}
