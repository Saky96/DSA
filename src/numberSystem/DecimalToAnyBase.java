package numberSystem;

import java.util.Scanner;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
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
}
