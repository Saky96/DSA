/*
* Example of static Sliding Window
*
* */

package arrays;

public class MaxSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(maxSubArray(input, 3));
    }

    private static int maxSubArray(int[] input, int k) {
        int maxSize = Integer.MIN_VALUE;
        int currentSize = 0;
        for (int i = 0; i < input.length; i++) {
            currentSize += input[i];
            if(i >= k - 1){
                maxSize = Math.max(maxSize, currentSize);
                currentSize -= input[i - (k-1)];
            }
        }
        return maxSize;
    }
}
