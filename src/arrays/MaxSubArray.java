package arrays;

/*
* 53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
* */

public class MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-4, -1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(curSum < 0){
                curSum = 0;
            }

            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
