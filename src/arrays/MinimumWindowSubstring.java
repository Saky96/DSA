package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s  = "abc";
        String t = "ac";

//        System.out.println(minWindow(s, t));

        System.out.println(minWindow2("abaacbab", "aabc"));
    }

    // Tried Brute force and could pass a few test cases
    public static String minWindow(String s, String t) {
        List<String> minStr = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
//            StringBuilder subStr = new StringBuilder();
            String subStr = "";
            for (int j = i; j < s.length(); j++) {
//                 subStr.append(s.charAt(j));
                subStr = subStr + s.charAt(j);
                boolean isPresent = false;
                for (int k = 0; k < t.length(); k++) {
                    if(subStr.length() >= t.length() && subStr.indexOf(t.charAt(k)) >= 0){
                        isPresent = true;
                    }
                    else{
                        isPresent = false;
                        break;
                    }
                }
                if(isPresent){
                    minStr.add(subStr);
                }

//                System.out.println(subStr);
            }
        }
        int minCount = Integer.MAX_VALUE;
        String res = "";
        for (String str: minStr) {
            if(minCount > str.length()){
                minCount = str.length();
                res = str;
            }
        }
        System.out.println(minStr);


        return res;
    }

    // Trying two pointers and hashmap
    public static String minWindow2(String s, String t){
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        System.out.println(dictT);

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
