package numberSystem;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        findAllPrime(10);
    }

    static void findAllPrime(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);

        // 0 and 1 are not prime
        primes[0] = false;
        primes[1] = false;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
        for (int i = 2; i*i <= n; i++) {
            if(primes[i] == true){
                for (int j = i*i; j <= n; j+=i) {
                    primes[j] = false;
                }
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(primes));
        for(int i = 2; i <= n; i++)
        {
            if(primes[i] == true)
                System.out.print(i + " ");
        }
    }
}
