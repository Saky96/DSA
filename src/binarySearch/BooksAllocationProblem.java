package binarySearch;

public class BooksAllocationProblem {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int[] arr1 = {12, 34, 67, 90 };
        int students = 2;
        System.out.println(minimumPagesAllocated(arr1, students));
    }

    public static int minimumPagesAllocated(int[] arr, int m){  //m are the students
        int s = 0;
        int ans = -1;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            e = e + arr[i];
        }

        while (s<=e){
            int mid = s + (e - s)/2;
            if(isPossible(arr, mid, m)){
                e = mid - 1;
                ans = mid;
            }
            else {
                s = s+1;
            }
        }


        return ans;
    }

    public static boolean isPossible(int arr[], int mid, int m){

        int studCount = 1;
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(mid >= arr[i] + arrSum){
                arrSum += arr[i];
            }
            else {
                studCount++;
                if(studCount > m || arr[i] > mid){
                    return false;
                }
                arrSum = arr[i];
            }
        }
        return true;
    }
}
