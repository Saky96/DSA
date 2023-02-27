package sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 11, 5, 3};
        int l = 0;
        int r = arr.length - 1;
        quickSort(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }

    public static List<Integer> quickSort2(List<Integer> arr){
        // Write your code here.
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            arr2[i] = arr.get(i);

        int l = 0;
        int r = arr2.length - 1;
        quickSort(arr2, l, r);

        arr = Arrays.stream(arr2).boxed().toList();
        return arr;
    }

    static void quickSort(int [] arr, int l, int r){

        //Base Case
        if(l>r){
            return;
        }

        int pivot = arr[r];

        //Find partition element
        int p = partition2(arr, l, r, pivot);

        //Sort left part
        quickSort(arr,l, p-1);

        //Sort right part
        quickSort(arr,p+1, r);
    }

    static int partition(int[] arr, int l, int r){
        int pivot = arr[l];
        int i = l;
        int j = r;

        while(i<j){
            while (arr[i] <= pivot) i++;
            while (arr[i] > pivot) j--;
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr ,i, j);
        return j;
    }

    static int partition2(int[] arr, int l, int r, int pivot){
//        int pivot = arr[r];
        int i = l;
        int j = l;
        //Three regions in partition logic
        // i to end -> unknown elements
        // j to i-1 -> elements greater than pivot
        // 0 to j-1 -> elements smaller than or equal to pivot
        while (i <= r){
            if(arr[i] <= pivot){
                swap(arr, i, j);
                i++;
                j++;
            }
            else {
                i++;
            }
        }

        return (j-1);
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
