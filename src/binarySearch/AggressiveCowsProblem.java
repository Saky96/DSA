package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AggressiveCowsProblem {

    public static void main(String[] args) {
        Integer[] stallsArr = {4, 2, 1, 3, 6};
        ArrayList<Integer> stalls = new ArrayList<>();
        stalls.addAll(Arrays.asList(stallsArr));
        System.out.println(aggressiveCows(stalls, 2));
    }

    public static int aggressiveCows(ArrayList<Integer> stalls, int k)
    {
        //    first I will find the range.
        stalls.sort(Comparator.naturalOrder());
        System.out.println(stalls);
        int s = 0;
        int e = 0;
        for (var stall: stalls) {
            e += stall;
        }
        int ans = -1;
        while (s<e){
            int mid = s+(e-s)/2;
            if(isPossible(stalls, k, mid)){
                s = mid + 1;
                ans = mid;
            }
            else{
                e = mid - 1;
            }
        }
        return ans;
    }

    static boolean isPossible(ArrayList<Integer> stalls, int k, int mid){
        //correct the logic here
//        int cowCount = 0;
//        int lastPos = stalls.get(0);
//
//        for (var stall: stalls) {
//            if(stall-lastPos >= mid){
//                cowCount++;
//                if(cowCount == k){
//                    return true;
//                }
//                lastPos = stall;
//            }
//        }

        return false;
    }
}
