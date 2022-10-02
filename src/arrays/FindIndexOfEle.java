package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindIndexOfEle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Integer[] arr = new Integer[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int element = scn.nextInt();

        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == element){
                index = i;
                break;
            }
        }
        System.out.println("Using Array: "+index);
        System.out.println("Using ArrayList: "+usingArrayList(element, arrList));
    }

    public static int usingArrayList(int ele, ArrayList<Integer> arrList){
        return arrList.indexOf(ele);
    }
}
