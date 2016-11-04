package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/2/2016.
 */
public class NthPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        int[] cases = new  int[T];

        int max = 0;
        for (int j = 0; j < T; j++) {
            int N = scanner.nextInt();
            max = max > N ? max : N;
            cases[j] = N;
        }
        long primeNumbers[] = nthPrime(max);
        for (int i = 0; i < T; i++) {
            System.out.println(primeNumbers[cases[i]-1]);
        }
//        Arrays.stream(primeNumbers).forEach(System.out::println);
    }

    private static long[] nthPrime(int max) {
        long[] primeNumbers = new long[max+1];
        primeNumbers[0] = 2L;

        long p = 3L; boolean prime; int i = 1;
        while (i < max) {
            prime = true;
            long sqrt = (long) Math.ceil(Math.sqrt(p));

            for (int j = 0; j < i && primeNumbers[j] <= sqrt ; j++) { // divide number with primes preceding it
                if (p % primeNumbers[j] == 0){
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeNumbers[i] = p;
                i++;
            }
            p += 2L;
        }
        return primeNumbers;
    }
}
