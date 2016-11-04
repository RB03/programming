package hackerrank.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/7/2016.
 * INCOMPLETE
 */
public class RemainingFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = Long.valueOf(sc.next());
        BigInteger pow = new BigInteger(String.valueOf(k));
        long time = System.currentTimeMillis();
        System.out.println(nthPrime(k).toString());
        System.out.println(System.currentTimeMillis() - time);

    }

    private static ArrayList<Long> nthPrime(long max) {
        ArrayList<Long> primeNumbers = new ArrayList<>();
        primeNumbers.add(0,2L);

        long p = 3L; boolean prime; int i = 1;
        while (p < Math.ceil(Math.sqrt(max))) {
//            System.out.println(p);
            prime = true;
            long sqrt = (long) Math.ceil(Math.sqrt(p));

            for (int j = 0; j < i && primeNumbers.get(j) <= sqrt ; j++) {
                if (p % primeNumbers.get(j) == 0){
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeNumbers.add(p);
                i++;
            }
            p += 2L;
        }
        return primeNumbers;
    }
}
