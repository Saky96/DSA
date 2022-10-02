package numberSystem;

import java.util.Scanner;

public class PrimeFactorisation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int divident = num;
        int divisor = 2;

        while(divident != 1){
            int remainder = num % divisor;
            if(remainder == 0){
                num = divident / divisor;
                System.out.print(divisor +"\s");
                divident = num;
            }
            else {
                divisor = divisor + 1;
            }
            if(divisor * divisor > divident){
                System.out.println(divident);
                break;
            }
        }
    }
}
