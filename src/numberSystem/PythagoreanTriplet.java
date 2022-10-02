/*
* Pythagorean Triplet
Easy

1. You are required to check if a given set of numbers is a valid pythagorean triplet.
2. Take as input three numbers a, b and c.
3. Print true if they can form a pythagorean triplet and false otherwise.
* */

package numberSystem;

import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int temp = a>b?a:b;

        int hypotenuse = c > temp? c: temp;

        if(hypotenuse == a && Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2))){
            System.out.println(true);
        }
        else if(hypotenuse == b && Math.pow(b, 2) == (Math.pow(a, 2) + Math.pow(c, 2))){
            System.out.println(true);
        }
        else if (hypotenuse == c && Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }

    }
}
