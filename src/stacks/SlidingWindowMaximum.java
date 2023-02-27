package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
//        int[] a = new int[n];
//        for(int i = 0; i < n; i++){
//            a[i] = Integer.parseInt(br.readLine());
//        }
//        int k = Integer.parseInt(br.readLine());

        int n = 11;
        int[] a = {4, 1, 3, 5,1,2,3,2,1,1,5};
        int k = 3;

//        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(ngtr(a)));
//        var ngtRindices = ngtr(a);
//        List<Integer> ngtrResult = new ArrayList<>();
//        for (var idx: ngtRindices) {
//                ngtrResult.add(a[idx]);
//        }
//        System.out.println(ngtrResult);

//        System.out.println(findMax(n, a, k));
        System.out.println(findMaxOptimized(n, a, k));
    }

    static int[] ngtr(int[] a){
//        List<Integer> result = new ArrayList<>();
        int len = a.length;
        int[] result = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(len - 1);
        result[len - 1] = a.length;

        for(int i=len-2; i>=0; i--){
            while(st.size()>0 && a[st.peek()] <= a[i] ){
                st.pop();
            }

            if(st.isEmpty()){
                result[i] = a.length;
            }
            else {
                result[i] = st.peek();
            }

            st.push(i);
        }

        return result;
    }

//    static List<Integer> findMaxOptimized(int n, int[] a, int k){
////        int[] result = new int[n-k+1];
//        List<Integer> result = new ArrayList<>();
//
//        int len = a.length;
//        int[] ngr = new int[len];
//        Stack<Integer> st = new Stack<>();
//        st.push(len - 1);
//        ngr[len - 1] = a.length;
//
//        for(int i=len-2; i>=0; i--){
//            while(st.size()>0 && a[st.peek()] <= a[i] ){
//                st.pop();
//            }
//
//            if(st.isEmpty()){
//                ngr[i] = a.length;
//            }
//            else {
//                ngr[i] = st.peek();
//            }
//
//            st.push(i);
//        }
//
//        int j = 0;
//        for (int i = 0; i <= a.length - k; i++) {
//            //enter the loop to find maximum of window starting at i
//            if(j < i){
//                j = i;
//            }
//            while(ngr[j] < i+k){
//                j = ngr[j];
//            }
//            System.out.println(a[j]);
//            result.add(a[j]);
//
//        }
//        return result;
//    }

    static List<Integer> findMaxOptimized(int n, int[] a, int k){
        List<Integer> result = new ArrayList<>();

        int[] nge = ngtr(a);

        int j=0;
        for (int i = 0; i < a.length - k +1; i++) {
//            int j = i;
            if(i > j){
                j=i;
            }
            while (nge[j] < i+k){
                j = nge[j];
            }

            result.add(a[j]);
        }
        return result;
    }

    static List<Integer> findMax(int n,int[] a,int k){
        List<Integer> result = new ArrayList<>();
        int max=0;
        for (int i = 0; i < n-k+1; i++) {
            max = a[i];
            for(int j=i; j<i+k; j++){
                if(max < a[j]){
                    max = a[j];
                }
            }
            result.add(max);
        }
        return  result;
    }
}
