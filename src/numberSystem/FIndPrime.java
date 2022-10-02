package numberSystem;

import java.util.Scanner;

public class FIndPrime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();

        for(int i=low; i<=high; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
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
//            System.out.println("not prime");
            return false;
        }

//        System.out.println("prime");
        return true;
    }
}
