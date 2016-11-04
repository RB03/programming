package hackerrank.algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/11/2016.
 */
public class MatchingSets2 {
    public static void main(String[] args) {
        BigInteger cost = BigInteger.ZERO;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] X = new long[N];
        long[] Y = new long[N];
        for (int i = 0; i < N; i++) {
            X[i]  = sc.nextLong();
        }
        Arrays.sort(X);
        for (int i = 0; i < N; i++) {
            Y[i]  = sc.nextLong();
        }
        Arrays.sort(Y);

        if (N == 1){
            if (X[0] == Y[0]){
                System.out.println(0);
                System.exit(0);
            }  else {
                System.out.println(-1);
                System.exit(0);
            }
        }

        long Z = absoluteSummation(X,Y,N);
        long C = summation(X, Y, N);
        System.out.println(Z+" "+C);

        if (C == 0L){
            System.out.println(Z/2);
        } else {
            System.out.println(-1);
        }

    }

    private static long summation(long[] x, long[] y, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += y[i] - x[i];
        }
        return sum;

    }

    private static long absoluteSummation(long[] x, long[] y, int N) {
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(y[i] - x[i]);
        }
        return sum;
    }
}
