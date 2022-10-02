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

        while (num != 0){
            int digit = num % 10;
            System.out.println(digit);
            num = num / 10;
        }
    }
}
