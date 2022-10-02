package numberSystem;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import numberSystem.CountDigitsInNum;

public class PrintDigitsOfNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int totalDigits = CountDigitsInNum.countDigits(num);
        int divisor = (int) Math.pow(10, totalDigits - 1);

        while (divisor != 0){
            int digit = num / divisor;
            System.out.println(digit);
            num = num % divisor;
            divisor = divisor / 10;
        }

    }

}
