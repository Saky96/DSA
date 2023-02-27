package binarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindFirstLastOccurance {
    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};

        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {


        int first = firstOccurance(nums, target);
        int last = lastOccurance(nums, target);

        int[] ans = {first, last};

        return ans;

    }

    public static int firstOccurance(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;

        while(l <= r){
            int mid = (l + r)/2;
            if(target == nums[mid]){
                ans = mid;
                r = mid - 1;
            }

            else if(target > nums[mid]){
                l = mid + 1;
            }

            else if(target < nums[mid]){
                r = mid -1;
            }
        }

        return ans;
    }

    public static int lastOccurance(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;

        while(l <= r){
            int mid = (l + r)/2;
            if(target == nums[mid]){
                ans = mid;
                l = mid + 1;
            }

            else if(target > nums[mid]){
                l = mid + 1;
            }

            else if(target < nums[mid]){
                r = mid -1;
            }
        }

        return ans;
    }
}
