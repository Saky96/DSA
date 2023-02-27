package hashing;

import java.util.*;

public class SubArrayQuestions {
    public static void main(String[] args) {
        int[] arr = {10, 15, -5, 15, -10, 5};
        int sum = 25;
//        subArrayWithGivenSum(arr, sum);
//        System.out.println(numberOfSubArraysWithGivenSum(arr, sum));
        int[] arr2 = {1,2,2,1,3,1,1,3};
        int window = 4;
//        System.out.println(maxDistinctElementsInWindow1(arr2, window));
        maxDistinctElementsInWindow2(arr2, window);
    }

    static void subArrayWithGivenSum(int[] arr, int sum){
        List<Integer> subArr = new ArrayList<>();
        int curSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];

            if(curSum - sum == 0){
                start = 0;
                end = i;
                break;
            }

            if(map.containsKey(curSum - sum)){
                start = map.get(curSum - sum) + 1;
                end = i;
                break;
            }

            map.put(curSum, i);
        }

        if(end == -1){
            System.out.println("No subArr found");
        }
        else {
            for (int i = start; i <= end; i++) {
                subArr.add(arr[i]);
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("Start: "+start+" End: "+ end);
            System.out.println(subArr);
        }
    }


    /*
    * 560. Subarray Sum Equals K
    * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
      A subarray is a contiguous non-empty sequence of elements within an array.
     * */
    static int numberOfSubArraysWithGivenSum(int[] nums, int k) {
        int curSum = 0;
        int result = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        for(int i=0; i<nums.length; i++){
            curSum += nums[i];
            int diff = curSum - k;

            if(prefix.containsKey(diff)){ //Checking that current diff = (sum - k) is already stored
                result += prefix.get(diff);
            }

            prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        }

        return result;
    }

    /*
    * Find max distinct elements in a window of size k
    *
    * */
    static int maxDistinctElementsInWindow1(int[] arr, int w){ // Time Complexity = O(n*w), Space Complexity = O(w)
        int count = 0;
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int wSize = (i + w) - 1;
            if(wSize >= arr.length){
                break;
            }
            for (int j = i; j <= wSize; j++) {
                numFreqMap.put(arr[j], numFreqMap.getOrDefault(arr[j], 0) + 1);
            }
            int mapSize = numFreqMap.size();
            System.out.println("Count in this window: "+mapSize);
            if(count < mapSize){
                count = mapSize;
            }
            numFreqMap.clear();
        }
        return count;
    }

    static void maxDistinctElementsInWindow2(int[] arr, int k){
        //Based on Acquire, Process, Release mechanism
        Map<Integer, Integer> numFreqMap = new HashMap<>();

        //Acquire  first window
        for (int i = 0; i < k; i++) {
            numFreqMap.put(arr[i], numFreqMap.getOrDefault(arr[i], 0) + 1);
        }

        // Process the window
        System.out.println("Count in this Window: "+ numFreqMap.size());

        for (int i = k; i < arr.length; i++) {
            //Release the element from window
            if(numFreqMap.get(arr[i-k]) == 1){
                numFreqMap.remove(arr[i-k]);
            }
            else {
                numFreqMap.put(arr[i-k], numFreqMap.getOrDefault(arr[i-k], 0) - 1);
            }
            //Acquire the next window
            numFreqMap.put(arr[i], numFreqMap.getOrDefault(arr[i], 0) + 1);

            //Process the window
            System.out.println("Count in this Window: "+ numFreqMap.size());
        }
    }
}
