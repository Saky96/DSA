package arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class FrequencyOfMostFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int[] nums2 = {1,4,8,13};
        System.out.println(maxFrequency(nums2, 5));
    }

    public static int maxFrequency(int[] nums, int k) {
        int maxFreq = 0;
        int n = nums.length;
        Arrays.sort(nums);
//        OptionalInt max = Arrays.stream(nums).max();
        int max = 0;
        int rev = n;
        while(rev != 0){
            max = nums[rev - 1];
            int freq = 1;
            for (int i = 0; i < rev - 1; i++) {
                int balance = max - nums[i];
                k = k - balance;
                if(k < 0){
                    break;
                }
                else {
                    freq++;
                }
            }
            maxFreq = Math.max(maxFreq, freq);
            rev--;
        }


        return maxFreq;
    }
}
