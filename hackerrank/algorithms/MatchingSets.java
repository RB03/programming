package hackerrank.algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/11/2016.
 */
public class MatchingSets {
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
        Arrays.stream(X).forEach(System.out::print);
        System.out.println();
        Arrays.stream(Y).forEach(System.out::print);
        System.out.println();

        for (int i = 0; i < N - 1; i++) {
            if (X[i] == Y[i]) continue;
            if (X[i] < Y[i]){
                for (int j = i+1;  (X[i] != Y[i] )&& j < N ; j=j+1) {
                    long difference = Y[i] - X[i];
                    if (X[j] > Y [j]){
                        long diff = X[j] - Y[j];
                        difference = difference >= diff ? diff : diff - difference;
                        cost = cost.add(new BigInteger(String.valueOf(difference)));
                        X[i] += difference;
                        X[j] -= difference;
                    }
                }
            } else {
                for (int j = i+1; (X[i] != Y[i] )&& j < N; j= j+1) {
                    long difference = X[i] - Y[i];
                    if (X[j] < Y [j]){
                        long diff = Y[j] - X[j];
                        difference = difference >= diff ? diff : diff - difference;
                        cost = cost.add(new BigInteger(String.valueOf(difference)));
                        X[i] -= difference;
                        X[j] += difference;
                    }
                }
            }
            Arrays.stream(X).forEach(System.out::print);
            System.out.println();
        }

        if (Arrays.equals(X, Y)){
            System.out.println(cost.toString());
        } else {
            System.out.println(-1);
        }
    }
}


