package binarySearch;

public class SearchInSortedAndRotated {
    public static void main(String[] args) {
        int[] numsArr = {4,5,6,7,0,1,2};
        System.out.println(searchInSortedAndRotated(numsArr, 2));
    }

    static int searchInSortedAndRotated(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1 ;

        while(l<=r){
            int mid = ( l + r ) / 2;

            if(nums[mid] == target){
                return mid;
            }

            //Left sorted array
            if(nums[mid] >= nums[l]){
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
}
