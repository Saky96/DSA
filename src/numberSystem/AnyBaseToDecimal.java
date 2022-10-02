package numberSystem;

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    private static int getValueIndecimal(int n, int b) {
        int result = 0;
//        int counter = 0;
        int p = 1;
        while(n!=0){
            int d = n % 10;
            result = result + d * p;
            p = p * b;
//            result = result + d * (int) Math.pow(b, counter);
//            counter ++;
            n = n / 10;
        }

        return result;
    }
}
