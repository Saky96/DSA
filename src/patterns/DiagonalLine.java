package patterns;

import java.util.Scanner;

public class DiagonalLine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int space = 0;

        for (int i = 1; i <= num ; i++) {
            for (int j = 1; j <= space ; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            space++;
            System.out.println();
        }
    }
}
