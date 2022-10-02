/*
Largest Area Histogram 2
Hard

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

Challenge. Could u solve it in one iteration.
Note. This question is same as Largest Area Histogram just the constrains are higher.

Constraints
1. 1 <= heights.length <= 10^5
2. 0 <= heights[i] <= 10^4
*/

package stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LargestAreaHistogram {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] rb = NextSmallerElementToRight.solveIndex(heights);
        int[] lb = NextSmallerElementToLeft.solveIndex(heights);
        int len = heights.length;
        int[] width = new int[len];
//        int[] area = new int[len];
        int maxArea = 0;

        for (int i = 0; i < len; i++) {
            width[i] = rb[i] - lb[i] - 1;
            int area = heights[i] * width[i];
            if(area > maxArea){
                maxArea = area;
            }
        }

        return maxArea;
    }
}
