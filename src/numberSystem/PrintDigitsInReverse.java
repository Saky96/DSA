/*
Reverse A Number
Easy

1. You've to display the digits of a number in reverse.
2. Take as input "n", the number for which digits have to be display in reverse.
3. Print the digits of the number line-wise, but in reverse order.
*
* */
package numberSystem;

import java.util.Scanner;

public class PrintDigitsInReverse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int res = 0;
        int pow = countDigits(num);
        while (num != 0){
            int digit = num % 10;
            num = num / 10;
//            System.out.println(digit);
            res = (int) (res + digit * Math.pow(10, pow-1));
            pow--;
        }
        System.out.println(res);
    }


    public static int countDigits(int num){
        int count = 0;
        while (num != 0){
            num = num / 10;
            count++;
        }
        System.out.println(count);
        return count;
    }
}
