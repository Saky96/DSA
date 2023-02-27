/*
* Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.*/

package binarySearch;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(36));
        System.out.println(precision(mySqrt(37), 4, 37));
    }

    public static double precision(double ans, int precision, int number){
        // For computing the fractional part
        // of square root upto given precision
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= number) {
                ans += increment;
            }

            // loop terminates when ans * ans > number
            ans = ans - increment;
            increment = increment / 10;
        }
        return (float)ans;
    }

    public static int mySqrt(int x) {
        long l = 0;
        long r = x;
        long ans = 0;
//        int mid;
        while(l <= r){
             long mid = l+(r-l)/2;
//            long mid = (l+r) / 2;

            if(mid*mid < x){
                l = mid + 1;
                ans = mid;
            }
            else if(mid*mid > x){
                r = mid - 1;
            }
            else{
                return (int)mid;
            }
        }

        return (int)ans;
    }
}
