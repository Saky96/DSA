package dynamicProgramming.tabulation;

import java.util.Arrays;

public class gridTraveller {
    public static void main(String[] args) {
        System.out.println(numOfPathsInGrid(3, 2)); // 3
        System.out.println(numOfPathsInGrid(3, 3)); // 6
    }

    //Time complexity: O(m*n)
    //Space complexity: O(m*n)
    static int numOfPathsInGrid(int m, int n){
        int[][] table = new int[m+1][n+1];

        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int current = table[i][j];
                if(j+1 <= n) table[i][j+1] += current;
                if(i+1 <= m) table[i+1][j] += current;
            }
        }
        System.out.println(Arrays.deepToString(table));

        return table[m][n];
    }
}
