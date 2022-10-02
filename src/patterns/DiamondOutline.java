package patterns;

import java.util.Scanner;

public class DiamondOutline {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        if (num % 2 == 0){
            System.out.println("Please enter odd numbers");
            return;
        }

        int outerSp = num / 2;
        int innerSp = -1;


        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= outerSp; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for (int j = 1; j <= innerSp; j++) {
                System.out.print("\t");
            }
            if(i>1 && i<num){
                System.out.print("*\t");
            }
            if(i <= num /2){
                outerSp--;
                innerSp = innerSp + 2;
            }
            else {
                outerSp++;
                innerSp = innerSp - 2;
            }
            System.out.println();
        }
    }
}
