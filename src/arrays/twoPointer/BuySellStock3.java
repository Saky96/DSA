/*
122. Best Time to Buy and Sell Stock II
Medium
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
* */

package arrays.twoPointer;

public class BuySellStock3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxP = 0;
        int tr1 = 0;
        int tr2 = 0;

        while(r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
//                maxP = maxP + profit;
                tr1 = profit;
                if(tr1 > tr2){
                    int temp = tr1;
                    tr1 = tr2;
                    tr2 = temp;
                }
                l = l + 1;
            }
            else{
                l = r;
            }
            r = r + 1;
        }
        maxP = tr1 + tr2;
        return maxP;
    }
}
