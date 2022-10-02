package patterns;

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cols = (n*2)-1;
        int colVal = 1;
        int sp = cols -2;

        for (int i = 1; i <= n ; i++) {
            int colNum = 1;
            for (int j = 1; j <= colVal ; j++) {
                System.out.print(colNum+"\t");
                colNum++;
            }
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            if(i == n){
                colVal = colVal -1;
            }
            int colNumRev=colVal;

            for (int j = 1; j <= colVal; j++) {
                System.out.print(colNumRev+"\t");
                colNumRev--;
            }
            sp -= 2;
            colVal ++;
            System.out.println();
        }
    }
}
