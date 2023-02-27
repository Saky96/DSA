package recursion;

public class SayNumber {
    public static void main(String[] args) {
        String[] numStrArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        sayDigitsOfNumber(412, numStrArr);
    }

    static void sayDigitsOfNumber(int num, String[] numStrArr){

        //Base case
        if(num == 0){
            return;
        }

        //Processing
        int digit = num % 10;
        num = num / 10;

        //Recursive call
        sayDigitsOfNumber(num, numStrArr);

        System.out.print(numStrArr[digit]+ " ");

    }
}
