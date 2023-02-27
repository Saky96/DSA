package dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridUniquePaths {
    public static void main(String[] args) {
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(uniquePaths(3, 3, memo));
    }

    public static int uniquePaths(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        if(memo.containsKey(key)) return memo.get(key);
        if(n==1 || m==1) return 1;
        if(n == 0 || m == 0) return 0;
        int res = uniquePaths(m-1, n, memo) + uniquePaths(m, n-1, memo);
        memo.put(key, res);
        return res;
    }
}
