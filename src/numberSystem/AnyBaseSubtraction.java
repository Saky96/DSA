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
        int result = 0;
        int p = 0;
        int carry = 0;
        while(n1!=0 || n2!=0){

            int d1 = n1 % 10;
            int d2 = n2 % 10 + carry;

            if(d2<d1){
                 d2 = d2 + b;
                 carry = -1;
            }
            else {
                carry = 0;
            }

            n2 = (n2 /10);
            n1 = n1 / 10;

            int sub = d2 - d1;
            result = result + sub * (int) Math.pow(10, p);
            p++;
        }
        return result;
    }
}
