package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class FindStockSpan {
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
        st.push(0);
        ans[0] = 1;

        for (int i = 1; i < arrLen; i++) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = i+1;
            }
            else {
//                ans[i] = i - indexOf(arr, st.peek());
                ans[i] = i - st.peek();
            }
            st.push(i);
        }

        return ans;
    }
//    public static int indexOf(int[] arr, int val) {
//        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
//    }
}
