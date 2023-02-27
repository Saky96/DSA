package numberSystem;

import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    private static int getDifference(int b, int n1, int n2) {
//        int result = 0;
//        int p = 1;
//        int carry = 0;
//        while(n2>0){
//
//            int d1 = n1 % 10;
//            int d2 = n2 % 10 + carry;
//
//            n1 = n1 / 10;
//            n2 = (n2 /10);
//
//            int d = d2 - d1 - carry;
//
//            if(d<0){
//                 carry = 1;
//                 d += b;
//            }
//            else {
//                carry = 0;
//            }
//
//            result = result + d * (int) Math.pow(10, p);
//            p++;
//        }
//        return result;

        int rv = 0;

        int c = 0;
        int p = 1;
        while (n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int d = d2 - d1 - c;

            if (d < 0) {
                c = 1;
                d += b;
            } else {
                c = 0;
            }

            rv += d * p;
            p = p * 10;
        }
        return rv;
    }
}
