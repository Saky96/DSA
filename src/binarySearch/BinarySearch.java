package binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int[] numsRotated = {300, 410, 40, 60, 80, 100};
        int[] numsArr = {4,5,6,7,0,1,2};
//        System.out.println(binarySearch(nums, 9));
//        System.out.println(searchInfinite(nums, 9));
//        System.out.println(searchInSortedAndRotated(numsArr, 0));
        System.out.println(pivotElement(numsArr));
    }

    static int binarySearch(int[] nums, int target){

        int start = 0;
        int end = nums.length - 1;

        while(end >= start){

            //Processing
//            int mid = start + (end - 1) / 2;
            int mid = (start + end) / 2;
            if(target == nums[mid]){
                return mid;
            }

            if(target > nums[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }

        }
        return -1;

    }

    static int binarySearchRecursion(int[] arr, int start, int end, int key){
        //base case
        if(end >= start){
            int mid = (start + end) / 2;

            if(arr[mid] == key){
                return mid;
            }

            if(arr[mid] > key){
                return binarySearchRecursion(arr, start, mid - 1, key);
            }
            else {
                return binarySearchRecursion(arr, mid + 1, end, key);
            }
        }
        return -1;
    }


    static int searchInfinite(int[] arr, int target){

        int start = 0, end = 1;

        while (arr[end] < target){

            start = end;
            end = 2* end;
        }

        return binarySearchRecursion(arr, start, end, target); //Can call iterative binary search as well
    }

    static boolean isSorted(int[] arr, int n){
        //Base case
        if(n == 0 || n == 1){
            return true;
        }

        //Recursive relation
        if(arr[n-1] < arr[n-2]){
            return false;
        }
        else {
            return isSorted(arr, n-1);
        }
    }

    static int searchInSortedAndRotatedRecursive(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        int resIdx = -1;

        if(isSorted(arr, mid)){
            resIdx = binarySearchRecursion(arr, start, mid, target);
        }
        else {
            resIdx = binarySearchRecursion(arr, mid, end, target);
        }

        if(resIdx == -1){
//            searchInSortedAndRotated()
        }
        return resIdx;
    }

//    static int searchInSortedAndRotated(int[] arr, int target){
//        int start = 0, end = arr.length - 1;
//
//        while (end >= start){
//            int mid = (start + end) / 2;
//
//            if(arr[mid] == target){
//                return mid;
//            }
//
//            if(arr[start] < arr[mid]){   //sorted left part of the array
//                if(target >= arr[start] && target < arr[mid]){
//                    end = end - 1;
//                }
//                else {
//                    start = start + 1;
//                }
//            }
//            else{ //Sorted Right part of the array
//                if(target <= arr[end] && target > arr[mid]){
//                    start = start + 1;
//
//                }
//                else {
//                    end = end - 1;
//                }
//            }
//        }
//        return -1;
//    }

    static int searchInSortedAndRotated(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1 ;

        while(l<=r){
            int mid = ( l + r ) / 2;

            if(nums[mid] == target){
                return mid;
            }

            //Left sorted array
            if(nums[l] <= nums[mid]){
                if(target > nums[mid] || target < nums[l]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            //Right sorted array
            else{
                if(target < nums[mid] || target > nums[r]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    static int pivotElement(int[] arr){
        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            int mid = (l+r) / 2;

            if(arr[mid] <= arr[l]){
                l = mid + 1;
            } else{
                r = mid;
            }
//            else {
//                r = mid;
//            }
        }
        return r;
    }
}
