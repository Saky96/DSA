package bitManipulation;

public class FindEvenOdd {
    public static void main(String[] args) {
        tellEvenOdd(13);
    }

    static void tellEvenOdd(int a){
        if((a & 1) == 0){
            System.out.println("Even number!");
        }
        else {
            System.out.println("Odd number!");
        }
    };
}
