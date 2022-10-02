package patterns;

import java.util.Scanner;

public class NumberDiamond {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sp = n / 2;
        int st = 1;
        int rowVal = 1;

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sp ; j++) {
                System.out.print("\t");

            }
            int colVal = rowVal;
            for (int j = 1; j <= st ; j++) {
                System.out.print(colVal+"\t");
                if(j <= st/2){
                    colVal++;
                }
                else {
                    colVal--;
                }
            }
            if(i <= n/2){
                sp--;
                st += 2;
                rowVal++;
            }
            else {
                sp++;
                st -= 2;
                rowVal --;
            }

            System.out.println();
        }
    }
}
