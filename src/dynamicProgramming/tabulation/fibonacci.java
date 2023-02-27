package dynamicProgramming.tabulation;

import java.util.Arrays;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6)); //8
        System.out.println(fib(7)); //13
        System.out.println(fib(8)); //21
        System.out.println(fib(50)); //12586269025
    }

    public static int fib(int n){
        int[] table = new int[n+1];
        Arrays.fill(table, 0);
        table[1] = 1;
        for (int i = 0; i <= n; i++) {
            if(i+1 <= n) table[i+1] += table[i];
            if(i+2 <= n) table[i+2] += table[i];
        }
//        System.out.println(Arrays.toString(table));

        return table[n];
    }
}
