package patterns;

import java.util.Scanner;

public class DiamondHole {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int star = (num/2) + 1;
        int  space= 1;

        if (num % 2 == 0){
            System.out.println("Please enter odd numbers");
            return;
        }

        for (int i = 1; i <= num ; i++) {
            for (int j = 1; j <= star ; j++) {
                System.out.print("*\t");
            }
            for (int j = 1; j <= space ; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= star ; j++) {
                System.out.print("*\t");
            }
            if(i <= num/2){
                space = space + 2;
                star--;
            }
            else {
                space = space -2;
                star++;
            }
            System.out.println();
        }
    }
}
