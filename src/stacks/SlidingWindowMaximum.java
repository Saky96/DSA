package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        System.out.println(Arrays.toString(a));


        System.out.println(findMax(n, a, k));
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
