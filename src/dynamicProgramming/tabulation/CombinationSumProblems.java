package dynamicProgramming.tabulation;

import java.util.Arrays;

public class CombinationSumProblems {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{3, 4, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));
    }

    // m = targetSum
    //n = candidates.length
    //Time Complexity: O(m*n)
    //Space Complexity: O(m)

    static boolean canSum(int target, int[] candidates){
        boolean[] table = new boolean[target + 1];
        table[0] = true;
        for (int i = 0; i <= target ; i++) {
            if(table[i] == true){
                for (int num:candidates) {
                   if(i+num <= target) table[i+num] = true;
                }
            }
        }
//        System.out.println(Arrays.toString(table));
        return table[target];
    }

//    static int[] howSum(int target, int[] candidates){
//        int[][] table = new int[target + 1][null];
//    }
}
