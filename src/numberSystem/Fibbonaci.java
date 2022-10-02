package numberSystem;

import java.util.Scanner;

public class Fibbonaci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int prev = 0;
        int current = 1;
        for(int i=0; i<num; i++){
            System.out.println(prev);
            int next = prev + current;
            prev = current;
            current = next;
        }
    }
}
