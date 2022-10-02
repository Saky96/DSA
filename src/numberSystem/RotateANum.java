package numberSystem;

import java.util.Scanner;

public class RotateANum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();


//        System.out.println(rotate(n, k));
        System.out.println(rotateV2(n, k));
    }

    static int rotate(int n, int k){
        int totalDigits = CountDigitsInNum.countDigits(n);
        int result = n;
        if(k>0){
            while (k>0){
                if(k % totalDigits != 0){
                    int digit = result % 10;
                    int divisor = result /10;
                    result = digit * (int) Math.pow(10, totalDigits - 1) + divisor;
                    k--;
                }
                else{
                    k = k - totalDigits;
                }
            }
        }
        else {
            int j=Math.abs(k);
            while (k < 0){
                if(j % totalDigits != 0) {
                    int digit = result / (int) Math.pow(10, totalDigits - 1);
                    int remainder = result % (int) Math.pow(10, totalDigits - 1);
                    result = remainder * 10 + digit;
                    k++;
                }
                else{
                    k = k + totalDigits;
                }
            }
        }

        return result;
    }

    // Version two uses an approach with better time complexity
    static int rotateV2(int n, int k){
        int totalDigits = CountDigitsInNum.countDigits(n);
        k = k % totalDigits;
        if(k < 0){
            k = k + totalDigits;
        }

        int divisor = (int)Math.pow(10, k);
        int multiplier = (int)Math.pow(10, totalDigits - k); // digits - rotations

        int frontDigits = n / divisor;
        int backDigits = n % divisor;

        int result = backDigits * multiplier + frontDigits;
        return result;
    }
}
