/*
Josephus Problem OR Find the Winner of the Circular Game
* There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

The rules of the game are as follows:

Start at the 1st friend.
Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
The last friend you counted leaves the circle and loses the game.
If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.
* */

package recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephProblem {
    public static void main(String[] args) {
        int k = 2; //Places to skip
        int n = 5; // Total people playing
        int start = 0; //for zero based indexing, change it to one for 1 based indexing
        List<Integer> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            people.add(i);
        }

//        System.out.println(people);
        System.out.println(josephusSolutionList(people, k, start));
        System.out.println(josephusSolutionRecursion(n, k));
    }


    //Solution using a List
    static int josephusSolutionList(List<Integer> people, int k, int index){

        if(people.size() == 1){
            return people.get(0);
        }

        index = (index + k-1) % people.size();
        people.remove(index);

        return josephusSolutionList(people, k, index);
    }

    static int josephusSolutionRecursion(int n, int k){
        if(n == 1){
            return 1;
        }

        return (josephusSolutionRecursion(n-1, k) + k) % n;
    }


}
