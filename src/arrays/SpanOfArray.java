package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SpanOfArray {

    //Using traditional array approach
/*    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int max = getMax(arr);
        int min = getMin(arr);
        int span = max - min;
        System.out.println(span);
    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }*/

    // Using Array list approach
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<Integer> intArr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            intArr.add(scn.nextInt());
        }

        int max = intArr.get(0);
        int min = intArr.get(0);

        for (int ele: intArr) {
            if(ele > max){
                max = ele;
            }
            if(ele < min){
                min = ele;
            }
        }

        int span = max - min;
        System.out.println(span);
    }
}
