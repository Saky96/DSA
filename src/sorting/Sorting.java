package sorting;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {9, 6, 2, 3, 1, 4};
//        System.out.println(Arrays.toString(swap(arr, 5, 0)));
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    static int[] bubbleSort(int[] arr){  // Time Complexity -> O(n^2)
        int n = arr.length;

        for (int i = 1; i < n; i++) { // or the condition could be -> for (int i = 0; i < n-1; i++)
            // loop for number of rounds
            boolean isSwapped = false; //Added for Optimization, if the array is already sorted
            for (int j = 0; j < n-i; j++) { // or the condition could be -> for (int j = 0; j < n-i-1; j++)
                // loop for processing elements
                if(arr[j] > arr[j+1]){
                    isSwapped = true;
                    swap(arr, j, j+1);
                }
            }
            if(!isSwapped){
                break;
            }
        }
        return arr;
    }

    static int[] selectionSort(int[] arr){ // Time Complexity -> O(n^2)
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;

            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            if(minIdx != i){
                swap(arr, minIdx, i);
            }
        }
        return arr;
    }

    static  int[] insertionSort(int[] arr){ // Time Complexity -> O(n^2)
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    static int[] swap(int[] arr, int minIdx, int i){
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
        return arr;
    }
}
