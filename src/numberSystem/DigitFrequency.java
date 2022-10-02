package numberSystem;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        int freq = 0;
        while(n!=0){
            int digit = n % 10;
            if(digit == d){
                freq += 1;
            }
            n = n /10;
        }
        return freq;
    }
}
