package patterns;

import java.util.Scanner;

public class ArrowPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int st = 1;
        int sp = n/2;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= sp ; j++) {
                if(i == (n/2) + 1){
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }

            for (int j = 1; j <= st ; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            if(i <= n/2){
                st += 1;
            }
            else {
                st -= 1;
            }
        }
    }
}