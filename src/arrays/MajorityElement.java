package arrays;

/*
* 169. Majority Element | Moore's Voting Algorithm
Easy
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
* */

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums2));
    }

    public static int majorityElement(int[] nums) {
        int count = 1;
        int midx = 0; //Majority element index
        int n = nums.length;
        for(int i = 1; i< n; i++){
            if(nums[midx] == nums[i]){
                count+= 1;
            }
            else{
                count -= 1;
            }

            if(count == 0){
                midx = i;
                count += 1;
            }
        }
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if(nums[midx] == nums[i]){
                maxCount += 1;
            }
        }
        if(maxCount > n/2){
            return nums[midx];
        }

        return -1;
    }
}
