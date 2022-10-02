package patterns;

import java.util.Scanner;

public class RightAlignedTriangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i = num; i >= 1; i--) {
            for (int j = i-1; j >= 1; j--) {
                System.out.print("\t");
            }
            for (int j = 1; j <= (num -i) + 1; j++) {
                System.out.print("*\t");
            }
            System.out.println("");
        }
    }
}
