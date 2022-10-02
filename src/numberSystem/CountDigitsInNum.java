package numberSystem;

import java.util.Scanner;

public class CountDigitsInNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        countDigits(num);
    }

    public static int countDigits(int num){
        int count = 0;
        while (num != 0){
            num = num / 10;
            count++;
        }
//        System.out.println(count);
        return count;
    }
}
