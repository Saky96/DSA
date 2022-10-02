package arrays;

import java.io.OptionalDataException;
import java.util.Scanner;

public class SubtractionOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        Integer[] arr1 = new Integer[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        Integer[] arr2 = new Integer[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        Integer[] resultArr = new Integer[n2];
        int k = resultArr.length - 1;

        while (k>=0){
            int d= 0;
            int d1 = 0;
            int d2 = 0;
            if(j>=0){
                d2 = arr2[j] + carry;
            }
            if(i >= 0){
                d1 = arr1[i];
            }
            if(d2 < d1){
                carry = -1;
                d2 = d2 + 10;
            }
            else {
                carry = 0;
            }
            d = d2 - d1;
            resultArr[k] = d;
            i--;
            j--;
            k--;
        }

//        for (int l =0; l<resultArr.length; l++) {
//            if(!(l==0 && resultArr[l] == 0)){
//                System.out.println(resultArr[l]);
//            }
//        }
        int idx = 0;
        while(idx < resultArr.length){
            if(resultArr[idx] == 0){
                idx++;
            }
            else {
                break;
            }
        }

        while (idx < resultArr.length){
            System.out.println(resultArr[idx]);
            idx++;
        }

    }
}
