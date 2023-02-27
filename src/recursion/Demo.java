package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        System.out.println(findFactorial(5));
//        printCounting(5);
//        System.out.println(findFibbonaci(3));
//        System.out.println(findFibbonaci(5));
////        printFibbonaci(6);
//        for (int i = 0; i < 10; i++) {
//            System.out.print(printFibbonaci(i) + " ");
//        }
//        int[] arr = {5, 2, 3};
//        System.out.println(isArraySorted(arr, 0));
//        System.out.println(sumOfArray(Arrays.asList(6, 3, 1)));
        System.out.println(sumOfArrayOptimized(new int[]{6, 3, 1}));
    }

    static int findFactorial(int n){
        if(n == 0){
            return 1;
        }

        return n * findFactorial(n-1);
    }

    static void printCounting(int n){
        if(n==0){
            return;
        }

        printCounting(n-1);
        System.out.println(n);
    }

    static int findFibbonaci(int n){
        if(n==0 || n==1){
//            System.out.println(n);
            return n;
        }
//        return findFibbonaci(n-1) + findFibbonaci(n-2);
        int ans = findFibbonaci(n-1) + findFibbonaci(n-2);
//        System.out.println(ans);
        return ans;
    }

    static int printFibbonaci(int n){
        if(n==0 || n==1){
//            System.out.println(n);
            return n;
        }

        return findFibbonaci(n-1) + findFibbonaci(n-2);
    }

    static boolean isArraySorted(int[] arr, int idx){
        //Base case
        if(idx == arr.length - 1 ){
            return true;
        }

        //recursive relation
        boolean recursionResult = isArraySorted(arr, idx + 1);

        //Processing
        return recursionResult && arr[idx] < arr[idx + 1];
    }

    static int sumOfArray(List<Integer> nums){
        if(nums.size() == 0) return 0;

        List<Integer> rest = nums.subList(1, nums.size());
        return nums.get(0) + sumOfArray(rest);
//        return sumOfArray(nums.length - 1) + nums[nums.length - 1];
    }

    static int sumOfArrayOptimized(int[] nums){
        return _sum(nums, 0);
    }

    static int _sum(int[] nums, int idx){
        if(idx == nums.length) return 0;
        return _sum(nums, idx + 1) + nums[idx];
    }

}
