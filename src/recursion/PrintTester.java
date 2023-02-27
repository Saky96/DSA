package recursion;

public class PrintTester {
    public static void main(String[] args) {
        printHello(5);
    }

    static void printHello(int n){
        if(n==0){
            return;
        }

        System.out.println("Hello");
        printHello(n-1);
        System.out.println("Out of "+ n);
    }
}
