package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {4, 2, 7, 11, 5, 3};
        int[] arr = {7, 4, 1, 3, 6, 8, 2, 5};
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r) / 2;
            mergeSort(arr, l, mid); //Applying merge sort on left half of array
            mergeSort(arr, mid+1, r); //Applying merge sort on right half of array
            int[] result = mergeSortedArrays(arr, l, mid, r);
            for (int m = l; m <= r; m++) {
                arr[m] = result[m];
            }
        }
    }

    static int[] mergeSortedArrays(int[] arr, int l, int mid, int r){
        int[] mergedArr = new int[arr.length];
        int i = l;
        int j = mid+1;
        int k = l;
        while (i<=mid && j<=r){
            if(arr[i]< arr[j]){
                mergedArr[k] = arr[i];
                i++;
            }
            else {
                mergedArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i<= mid){
            mergedArr[k] = arr[i];
            i++;
            k++;
        }

        while (j<=r){
            mergedArr[k] = arr[j];
            j++;
            k++;
        }

        return mergedArr;
    }
}
