package recursion;

public class SumOfN {
    public static void main(String[] args) {
//        System.out.println(sumOfNumbers(5));
        System.out.println(powerOfNum(3, 4));
    }

    static int sumOfNumbers(int n){
        if(n==1){
            return 1;
        }
        return n + sumOfNumbers(n-1);
    }

    static int powerOfNum(int n, int b){
        if(b==0){
            return 1;
        }
        System.out.println(b);
        return n * powerOfNum(n, b-1);
    }
}
