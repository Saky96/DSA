package recursion;

public class FindPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        int l = 0;
        int r = str.length() -1;
        System.out.println(isPalindrome(str, l, r));
    }

    static boolean isPalindrome(String s, int l, int r){
        if(l >= r){
            return true;
        }

        if(s.charAt(l) != s.charAt(r)){
            return false;
        }

        return isPalindrome(s, l+1, r-1);
    }
}
