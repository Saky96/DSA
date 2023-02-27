package dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {
    public static void main(String[] args) {
        Map<Integer, Integer> memo = new TreeMap<>();
        System.out.println(fib(7, memo));
    }

    static int fib(int n, Map<Integer, Integer> memo){
        if(memo.containsKey(n))return memo.get(n);
        if(n <= 2) return 1;

        int res = fib(n-1, memo) + fib(n-2, memo);
        memo.put(n, res);
        return res;
    }
}
