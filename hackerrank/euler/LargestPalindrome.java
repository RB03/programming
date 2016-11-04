package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/1/2016.
 */
public class LargestPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- >0){
            int palindrome  =0;
            int limit = scanner.nextInt();
            for (int i = 100; i <= 999; i++) {
                for (int j = 100; j<= 999; j++){
                    int prod = i*j;
                    if (prod > limit || j > i) break;
                    if (isPalindrome(String.valueOf(prod))){
                           palindrome = Math.max(palindrome, prod);
                    }
                }
            }
            System.out.println(palindrome);
        }
    }

    private static boolean isPalindrome(String prod) {
        return prod.equals(new StringBuilder(prod).reverse().toString());
    }
}
