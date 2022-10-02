package numberSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList inputNumbers = new ArrayList<>();
        for(int i=0; i<t; i++){
            inputNumbers.add(scn.nextInt());
        }
        inputNumbers.forEach(number -> isPrime((Integer) number));
    }
    public static boolean isPrime(Integer num){
        int totalDivisible = 0;

        for(int i = 2; i*i<=num; i++){
            if(num % i == 0){
                totalDivisible ++;
                break;
            }
        }
        if(totalDivisible > 0){
            System.out.println("not prime");
            return false;
        }

        System.out.println("prime");
        return true;
    }
}
