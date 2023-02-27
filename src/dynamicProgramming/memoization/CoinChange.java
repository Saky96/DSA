package dynamicProgramming.memoization;

import java.util.Arrays;

//Time Complexity: O(n*m), where n is number of coins and m is length of memory used.
//Space Complexity
public class CoinChange {
    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1, 2, 5};
        int[] dp = new int[amount + 1]; // Extra space for memoization
        Arrays.fill(dp, -1);
        dp[0] = 0; // To make num = 0  we need 0 coins
//        System.out.println(coinChange(coins, amount, dp));
        System.out.println(Arrays.toString(dp));

        System.out.println(coinChange2(new int []{2, 3, 5}, 8));
    }

    // Find the minimum number of denominations of coins in array 'coins' required to create a number 'num'
//    public static int coinChange(int[] coins, int amount, int[] dp){
//        if(amount == 0) return 0;
//
//        int ans = Integer.MAX_VALUE;
//
//        for (int i = 0; i < coins.length; i++) {
//            if(amount-coins[i] >= 0){
//
//                int subAns = 0;
//                if(dp[amount-coins[i]] == -1){ //If the dp array does not contains the answer we fill the subAns else we take the ans from dp array
//                    subAns = coinChange(coins, amount - coins[i],  dp);
//                }else {
//                    subAns = dp[amount-coins[i]];
//                }
//
//
//                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){ //if subAns + 1 is less than ans we change ans with subAns
//                    ans = subAns + 1;
//                }
//            }
//
//        }
//        dp[amount] = ans;
//        return ans;
//    }

    public static int coinChange2(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        int totalCoins = 0;

        for(int coin: coins){
            int remainder = amount - coin;
            int currentCoins = coinChange2(coins, remainder);
            if(currentCoins == 0 || totalCoins < currentCoins){
                totalCoins += 1;
            }
        }

        return totalCoins;
    }
}
