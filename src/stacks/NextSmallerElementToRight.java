package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextSmallerElementToRight {
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
        int[] ngei = solveIndex(a);
        display(nge);
        display(ngei);
    }
    public static int[] solve(int[] arr){
        int len = arr.length;
        int[] ans = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(arr[len -1]);
        ans[len-1] = -1;

        for (int i = len-2; i >= 0 ; i--) {
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
    public static int[] solveIndex(int[] arr){
        int len = arr.length;
        int[] ans = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(len -1 );
        ans[len-1] = len;

        for (int i = len-2; i >= 0 ; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                ans[i] = len;
            }
            else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }
}
