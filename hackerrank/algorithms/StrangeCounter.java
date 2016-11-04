package hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/2/2016.
 */
public class StrangeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong();
        long counter = 1;

        long x = (((1L << counter) - 1L) * 3); // 3, 9, 21, 45.. 2^3 -1
        while (T / x >= 1) {
            counter++;
            x = (((1L << counter) - 1L) * 3);
            if (T == x) {  // eg. 21/21 = 1 i.e same column but greater than 0
                break;
            }
        }
        long timer = (long) (1 << counter - 1) * 3L;
        System.out.println(timer - (T - (timer - 2L)));
    }
}
