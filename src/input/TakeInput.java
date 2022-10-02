package input;

import java.util.Scanner;

public class TakeInput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String name = scn.nextLine();
        int num = scn.nextInt();
        System.out.println("Hello "+name);
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }

    }
}
