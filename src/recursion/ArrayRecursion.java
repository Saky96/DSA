package recursion;

public class ArrayRecursion {
    public static void main(String[] args) {
//        int[] arr = {5, 4, 6, 3};
        int[] arr = {-1,0,3,5,9,12};
//        System.out.println(isSorted(arr, arr.length));
//        System.out.println(findSum(arr, arr.length));
//        System.out.println(linerSearch(arr, arr.length, 6));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 9));
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

    static int findSum(int[] arr, int n){
        //base case
        if(n <= 0){
            return 0;
        }

        //recursive relation
        return findSum(arr, n-1) + arr[n-1];
    }

    static boolean linerSearch(int[] arr, int size, int value){
        //base case
        if(size == 0){
            return false;
        }

        if(arr[size-1] == value){
            return true;
        }

        return linerSearch(arr, size-1, value);
    }

    static int binarySearch(int[] arr, int start, int end, int key){
        //base case
        if(end >= start){
            int mid = start + (end - 1) / 2;

            if(arr[mid] == key){
                return mid;
            }

            if(arr[mid] > key){
                return binarySearch(arr, start, mid - 1, key);
            }
            else {
                return binarySearch(arr, mid + 1, end, key);
            }
        }
        return -1;
    }

}
