package patterns;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        if (num % 2 == 0){
            System.out.println("Please enter odd numbers");
            return;
        }

        int space = num / 2;
        int star = 1;
        for (int i = 1; i <= num ; i++) {
            for (int j = 1; j <= space ; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= star ; j++) {
                System.out.print("*\t");
            }
            if(i <= num/2){
                space --;
                star = star + 2;
            }
            else {
                space ++;
                star = star - 2;
            }
            System.out.println();
        }
    }
}
