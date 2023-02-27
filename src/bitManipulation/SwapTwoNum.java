package bitManipulation;

import java.util.HashMap;
import java.util.Map;

public class SwapTwoNum {
    public static void main(String[] args) {
        int a = 7;
        int b = 5;

        System.out.println((swapNum(a, b)));

    }

    static Map swapNum(int a, int b){
        Map<String, Integer> numMap = new HashMap<>();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        numMap.put("a", a);
        numMap.put("b", b);
        return numMap;
    }
}
