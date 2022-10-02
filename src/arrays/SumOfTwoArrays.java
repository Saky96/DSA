package arrays;

import java.util.Scanner;

public class SumOfTwoArrays {
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

        int bigger = n1 > n2 ? n1 : n2;

        Integer[] resultArr = new Integer[bigger];

        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = resultArr.length - 1;
        while (k>=0){
//            int result = arr1[i] + arr2[j] + carry;
            int result = carry;
            if(i>=0){
                result = result + arr1[i];
            }
            if(j>=0){
                result = result + arr2[j];
            }
            resultArr[k] = result % 10;
            carry = result / 10;
            i--;
            j--;
            k--;
        }
        if(carry>0){
            System.out.println(carry);
        }

        for (int num : resultArr) {
            System.out.println(num);
        }
    }
}
