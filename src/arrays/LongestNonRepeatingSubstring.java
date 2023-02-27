package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring2(s2));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 1;
        if(s.isEmpty()){
            return 0;
        }
        int len = 1;
        int maxLen = 0;
        while(r < s.length()){
            if(s.charAt(l) != s.charAt(r)){
                len++;
                r++;

            }
            else {
                l++;
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
//            r++;
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }
}
