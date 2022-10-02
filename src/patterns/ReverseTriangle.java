package patterns;

import java.util.Scanner;

public class ReverseTriangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i = num; i >= 1; i--) {
            for(int j = i; j>=1; j--){
                System.out.print("*\t");
            }
            System.out.println("");
        }
    }
}
