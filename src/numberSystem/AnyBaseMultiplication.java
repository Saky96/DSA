package numberSystem;

import java.util.Scanner;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2){
        int result = 0;
        int counter = 0;
        while(n2!=0){
            int temp = result;
            int d2 = n2 % 10;
            int prod = getSingleProduct(b, n1, d2) * (int)Math.pow(10, counter);
            result = getSum(b, temp, prod);
            n2 = n2/10;
            counter++;
        }
        return result;
    }

    public static int getSingleProduct(int b, int n1, int n2){
        int result = 0;
        int counter = 0;
        int carry = 0;
        while(n1!=0 || carry != 0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;

            int mult = d1 * d2  + carry;
            int quesnt = mult / b;
            int rem = mult % b;

            if(mult >= b){
                result = result + rem * (int)Math.pow(10, counter);
                carry = quesnt;
            }
            else {
                result = result + mult  * (int)Math.pow(10, counter);
                carry = 0;
            }

            n1 = n1 / 10;
            counter++;
//            n2 = n2 / 10;
        }

        return result;
    }

    private static int getSum(int b, int n1, int n2) {

        int result = 0;
        int carry = 0;
        int power = 1;
        while (n1>0 || n2>0 || carry>0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;

            n1 = n1 /10;
            n2 = n2 /10;

            int d = d1+d2+carry;
            carry = d / b;
            d = d % b;

            result = result + d * power;
            power = power * 10;
        }

        return result;
    }
}
