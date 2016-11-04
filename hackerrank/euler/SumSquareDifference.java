package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/2/2016.
 */
public class SumSquareDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        while (T-- > 0){
            BigInteger num = scanner.nextBigInteger();
            BigInteger sum = (num.multiply(num.add(BigInteger.ONE))).divide(BigInteger.valueOf(2)).pow(2);
            BigInteger square = (num.multiply(num.add(BigInteger.ONE))
                    .multiply(num.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE)))
                    .divide(BigInteger.valueOf(6));
            System.out.println(sum.subtract(square).abs().toString());
        }
    }
}
