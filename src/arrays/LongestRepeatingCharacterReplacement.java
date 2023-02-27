package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABA", 1));
    }

    public static int characterReplacement(String s, int k) {

        Set<Character> allLetters = new HashSet<>();
        int maxLength=0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            allLetters.add(ch);
        }
//        System.out.println(allLetters);
        for (Character letter: allLetters) {
            int l = 0,  count = 0;

            // initialize a sliding window for each unique letter
            for(int r = 0; r < s.length(); r++){
                if(letter == s.charAt(r)){
                    count++;
                }

                while (!isWindowValid(l, r, count, k)){
                    if(s.charAt(l) == letter){
                        count--;
                    }
                    l = l+1;
                }

                // at this point the window is valid, update maxLength
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }

        return maxLength;
    }

    private static boolean isWindowValid(int start, int end, int count, int k) {
        int windowSize = end + 1 - start;
        boolean res = windowSize - count <= k;
        return res;
    }
}
