package numberSystem;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int  destBase= scn.nextInt();
        int ans = getValueInAnybase(n, sourceBase, destBase);
        System.out.println(ans);
    }

    private static int getValueInBase(int n, int b) {

        int result = 0;
        int counter = 0;
        while (n!=0){
            int r = n % b;
            result = result + r * (int)Math.pow(10, counter);
            counter ++;
            n = n / b;
        }
        return result;
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

    private static int getValueInAnybase(int n, int sourceBase, int destBase) {
        // convert any base to decimal and then convert decimal to any base.
        int decimalNum = getValueIndecimal(n, sourceBase);
        int destNum = getValueInBase(decimalNum, destBase);

        return destNum;
    }
}
