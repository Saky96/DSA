/*
* Gcd And Lcm
Easy

1. You are required to print the Greatest Common Divisor (GCD) of two numbers.

2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.

3. Take input "num1" and "num2" as the two numbers.

4. Print their GCD and LCM.
* */

package numberSystem;
import java.util.Scanner;

public class LCMandGCD {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();

        System.out.println(findGCD(num1, num2));
        System.out.println(findLCM(num1, num2));
    }

    static int findLCM(int num1, int num2){
        int gcd = findGCD(num1, num2);
        return (num1 * num2) / gcd;
    }

    static int findGCD(int num1, int num2){
        int divisor = 0;
        int divident = 0;
        if(num1 > num2){
            divident = num1;
            divisor = num2;
        }
        else {
            divident = num2;
            divisor = num1;
        }

        while (divident % divisor != 0){
            int remainder = divident % divisor;
            divident = divisor;
            divisor = remainder;

        }
        return divisor;
    }
}
