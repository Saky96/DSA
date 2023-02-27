package linkedList;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        int N = 10;
        int Q = 3;
        int[] si = {2, 3, 6};
        int[] ei = {5, 7, 8};

        System.out.println(leastStreetDist(N, Q, si, ei));
    }

    static int leastStreetDist(int N, int Q, int[] si, int[] ei){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < si.length; i++) {
            for (int j = 0; j < ei.length; j++) {
                if((si[i] + ei[j] )<= N){
                    res.add(N - (si[i]+ei[j]));
                }
            }
        }
        System.out.println(res);
        return Collections.min(res);
    }
}
