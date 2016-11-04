package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/31/2016.
 */

/*STEP-1: if the given N is even repeatedly divide by 2.

  STEP-2: if the N becomes 1 return 2 which is the largest prime factor.

  STEP-3: start with i=3, and check if the N is divisible by i. increment i by 2 (because there are no even factors for an odd number..). run the loop till square root of the N. if the N is divisible by i then divide the N by i and run the loop again from i =3. this step will eliminate all the composite numbers.

  STEP-4: finally if N is grater 2 then its a prime number. return N. else return i which is the largest prime number.
*/

public class GreatestPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0){
            long prime = scanner.nextLong();
            System.out.println(largestPrimeOf(prime));

        }
    }

    private static long largestPrimeOf(long prime) {
        long d;
        if ((prime & 1 ) == 0){         //true if even
            while (prime % 2 == 0){
                prime = prime >> 1;     // divide by 2
                if (prime == 1){
                    return 2L;
                }
            }
        }
        d = 3;
        while (d <= Math.sqrt(prime)) {
            if (prime%d == 0){
                prime /= d;
                d=3;
                continue;
            }
            d = d + 2;
        }
        if (prime > 2){
            return prime;
        } else {
            return d;
        }
    }
}
