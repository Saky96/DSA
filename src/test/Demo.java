package test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    // Declare a global list
    public static void main(String[] args) {
        String s = "abc";
        List<String> al = new ArrayList<>();
//        findsubsequences(s, "", al); // Calling a function
//        System.out.println(al);
//        int[] nums = {2,3,5,9};
        int[] nums = {1, 4, 5};
//        int k = 2;
        int k = 1;
//        System.out.println(minCapability(nums, k));
        al.add("bla");
        al.add("bla bla");
        List<String> bl = new ArrayList<>(al);
        bl.add("ala");
        bl.add("ala ala");
//        System.out.println(bl);

        List<Integer> combination = new ArrayList<>();
        combination.add(2);
        combination.add(2);
        combination.add(2);
        combination.add(2);
//        System.out.println(combination.stream().mapToInt(Integer::intValue).sum());
        System.out.println(maximumDifference(new int[]{87,68,91,86,58,63,43,98,6,40})); //55
        System.out.println(maximumDifference(new int[]{9,4,3,2})); //-1
    }


    private static void findsubsequences(String s, String ans, List<String>al) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }

        // adding 1st character in string
        System.out.println(s + " ----> " + ans);
        findsubsequences(s.substring(1), ans + s.charAt(0), al);

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        System.out.println(s + " ====> " + ans);
        findsubsequences(s.substring(1), ans, al);
    }

    public static int minCapability(int[] nums, int k) {
        int left = 0;
        int right = left + k;
        // int min = Integer.MAX_VALUE
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
//            while(k > 0){
                if(right >= nums.length) break;
                int temp = Math.max(nums[left], nums[right]);
                if(min > temp){
                    min = temp;
                }
                right = right + 1;
                if(right >= nums.length){
                    left++;
                    right = left + k;
                }
//                k--;
//            }

        }
        return min;
    }

    public static int minCapability2(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

        }
        return min;
    }

    public static int maximumDifference(int[] nums) {
        int i=0;
        int j=1;
        int max=-1;
        while(j < nums.length){
            if(nums[i] < nums[j]){
                int dif = nums[j] - nums[i];
                max = Math.max(max, dif);

            }
            else{
                i=j;
            }
            j++;
        }

//        int max=-1;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++)
//        {
//            if (nums[j]>nums[i])
//                max=Math.max(max,nums[j]-nums[i]);
//            else
//                i=j;
//        }
        return max;
    }

}
