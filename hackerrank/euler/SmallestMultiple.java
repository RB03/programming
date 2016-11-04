package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/1/2016.
 */

/*
M is divisible by all numbers from 1 to N iff M is equal to the product of all prime powers p^k where p is prime and divides M, and p < N, and k is the largest integer such that p^k < N. For example, 2520 = 2^3 * 3^2 * 5 * 7.
*/

public class SmallestMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());

        while (T-- > 0){
            int N = Integer.valueOf(scanner.nextLine());
            System.out.println(smallestMultiple(N));
        }

    }

    private static long smallestMultiple(int N) {
        long i;
        long mul = 1L;
        for (long prime = 2L; prime <= N; prime = nextPrime(i)){
            long prev = 1L; int k = 1;
            for (long pow = prime; pow <= N; pow = (long) Math.pow(prime, k)){
                k++;
                prev = pow;
            }
            mul *= prev;
            i = prime;
        }
        return mul;
    }

    private static long nextPrime(long n) {
        boolean isPrime = false;
        int start = 2;
        while (!isPrime) {
            n += 1;
            int m = (int) Math.ceil(Math.sqrt(n));
            isPrime = true;
            for (int i = start; i <= m; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return n;
    }

    static boolean isPrime(long num){
        if ( num > 2 && num%2 == 0 ) {
            return false;
        }
        int top = (int)Math.sqrt(num) + 1;
        for(int i = 3; i < top; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
