package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubStringsInAString {
    public static void main(String[] args) {
        String str = "abcde";
        List<String> allSubStrings = new ArrayList<>();
        String result = findSubStrings(str, 0, "");
        allSubStrings = Arrays.stream(result.split(",")).toList();
        System.out.println(allSubStrings);
        System.out.println(allSubStrings.size());
    }

    static String findSubStrings(String str, int i, String subStr){
        if(str.length() == i){
            System.out.println(subStr);
//            subStringList.add(subStr);
            return subStr;
        }

        return         findSubStrings(str, i+1, subStr) + ", " +
        findSubStrings(str, i+1, subStr + str.charAt(i));
//        return subStr;
    }
}
