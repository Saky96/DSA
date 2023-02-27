package arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println(Arrays.toString(nextGreaterElement(a)));
        System.out.println(Arrays.toString(nextSmallerElement(a)));
        System.out.println(trap(a));
    }

    public static int[] nextGreaterElement(int[] a){
        int n  = a.length;
        int[] rightArr = new int[n];
        rightArr[n-1] = a[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i+1], a[i]);
        }
        return rightArr;
    }

    public static int[] nextSmallerElement(int[] a){
        int n  = a.length;
        int[] leftArr = new int[n];
        leftArr[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftArr[i] = Math.max(leftArr[i-1], a[i]);
        }
        return leftArr;
    }


    public static int trap(int[] height) {
        int[] leftArr = nextGreaterElement(height);
        int[] rightArr = nextSmallerElement(height);
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans = ans + Math.min(leftArr[i], rightArr[i]) - height[i];
        }
        return ans;
    }
}
