/*
* The Curious Case Of Benjamin Bulbs
Easy

1. You are given n number of bulbs. They are all switched off. A weird fluctuation in voltage hits the circuit n times. In the 1st fluctuation all bulbs are toggled, in the 2nd fluctuation every 2nd bulb is toggled, in the 3rd fluctuation every 3rd bulb is toggled and so on. You've to find which bulbs will be switched on after n fluctuations.
2. Take as input a number n, representing the number of bulbs.
3. Print all the bulbs that will be on after the nth fluctuation in voltage.
* */
package numberSystem;

import java.util.Scanner;

public class BenjaminBulbs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
//        approachBruteForce(num);
        approachTwo(num);
    }

    static void approachBruteForce(int num){
        boolean [] bulbs = new boolean[num];
        for(int i=0; i<num; i++){
            bulbs[i] = false;
        }
        for (int i = 0; i<bulbs.length; i++){
            if(i == 0){
                for (int i1 = 0; i1 < bulbs.length; i1++) {
                    bulbs[i1] = true;
                }
            }
            else {
                for (int j = i; j < bulbs.length; j++) {
                    if((j+1) % (i+1)  == 0){
                        bulbs[j] = !bulbs[j];
                    }
                }
            }
        }
        for (int i = 0; i < bulbs.length; i++) {
            if(bulbs[i]){
                System.out.println(i+1);
            }
        }
    }

    static void approachTwo(int num){
        for (int i = 1; i * i <= num; i++) {
            System.out.println(i * i);
        }
    }
}
