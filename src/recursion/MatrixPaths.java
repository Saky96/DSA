/*
*Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
* */

package recursion;

public class MatrixPaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println(uniquePaths(m,n));
    }

    static int uniquePaths(int m, int n) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
