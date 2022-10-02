package stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextSmallerElementToLeft {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nse = solve(a);
        int[] nsei = solveIndex(a);
//        display(nse);
        display(nsei);
    }

    public static int[] solve(int[] arr) {
        int len = arr.length;
        int[] ans  = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        ans[0] = -1;

        for (int i = 1; i < len; i++) {
            while (st.size() > 0 && arr[i] <= st.peek()){
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
    public static int[] solveIndex(int[] arr) {
        int len = arr.length;
        int[] ans  = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = -1;

        for (int i = 1; i < len; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        return ans;
    }

}
