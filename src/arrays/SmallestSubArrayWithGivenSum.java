/*
* An Example of Dynamic Sliding Window
* */

package arrays;

public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] input = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(smallestSubArray(input, 8));
    }

    private static int smallestSubArray(int[] input, int k) {
        int minSizeArr = Integer.MAX_VALUE;
        int currentSum = 0;
        int startWindow = 0;
        for (int endWindow = 0; endWindow < input.length; endWindow++) {
            currentSum += input[endWindow];

            while (currentSum >= k){
                minSizeArr = Math.min(minSizeArr, endWindow - startWindow + 1); // +1 for 0 base indexing of Array
                currentSum -= input[startWindow];
                startWindow++;
            }
        }
        return minSizeArr;
    }
}
