package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 10/16/2016.
 */

/*
Given N, Check if there exists any Pythagorean triplet for which a + b + c = N
Find maximum possible value of a, b, c among all such Pythagorean triplets, If there is no such Pythagorean triplet print -1.

b = [a^2 - (a - n)^2]/2(a - n)

*/


public class SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int T = scanner.nextInt();

        while (T-- > 0){
            int product = productOfPytho(scanner.nextInt());
            System.out.println(product);
        }

    }

    private static int productOfPytho(int num) {
        int max = -1;
        for (int i = 1; i < num; i++){
            int b = ((num - i)*(num - i) - i*i) / (2*(num - i));
            int c = (num - i - b);
//            System.out.println("a "+ i +" b "+b+" c "+c);
            if (i*i + b*b == c*c && b > 0 && c > 0){
                max = max < i*b*c ? i*b*c : max;
            }

        }
        return max;
    }
}
