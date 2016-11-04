package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/2/2016.
 */

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] primes = eratosthenes(N);
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] == 1L) {
                System.out.println(i);
            }
        }
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
