package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 10/18/2016.
 */
public class SumOfPrimes {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int T = scanner.nextInt(), max=0;
        int[] cases = new int[T];

        for (int i = 0; i < T; i++) {
            cases[i] = scanner.nextInt();
            max = max <  cases[i]? cases[i] : max;
        }

        long[] primes =  eratosthenes(max);
        long[] sums = summation(primes);

        for (int i = 0; i < T; i++) {
            System.out.println(sums[cases[i]]);
        }
    }

    private static long[] summation(long[] primes) {
        long[] sums = new long[primes.length];
        long previous = 0;
        sums[0] = 0; sums[1] = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 1L) {
                previous += i;
                sums[i] = previous;
            }
            else sums[i] = previous;

        }
        return sums;
    }

    private static long[] eratosthenes(int n) {
        long[] arr = new long[n + 1];
        Arrays.fill(arr, 1L); arr[0] = 0;
        long p = 2L, j, pow = (long) Math.pow(p, 2);

        while (pow < n) {
            j = pow;
            while (j <= n) {
                arr[Math.toIntExact(j)] = 0;
                j = j + p;
            }

            p++;
            while (arr[Math.toIntExact(p)] != 1L) {
                p++;
            }
            pow = (long) Math.pow(p, 2);
        }
        return arr;
    }
}
