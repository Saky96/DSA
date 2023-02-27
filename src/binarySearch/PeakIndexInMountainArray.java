/*
* An array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.
* */


package binarySearch;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,10,50,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right = arr.length -1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            } else if (arr[mid] > arr[mid+1]) {
                right = mid - 1;
            } else{
                right = mid;
            }
        }
        return left;
    }

}
