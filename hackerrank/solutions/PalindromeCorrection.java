package hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/23/2016.
 */

public class PalindromeCorrection {
    private static String palindrome;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        while (N-- > 0) {
            palindrome = scanner.nextLine();
            int length = palindrome.length();
            int middle = length / 2;
            int result = length % 2 == 0 ? findIndex(palindrome.substring(0, middle),
                    palindrome.substring(middle, length), 0, middle - 1, middle, length - 1)
                    : findIndex(palindrome.substring(0, middle),
                    palindrome.substring(middle + 1, length), 0, middle - 1, middle + 1, length - 1);

            System.out.println(result);
        }
    }

    private static int findIndex(String left, String right, int s, int m1, int m2, int e) {
        System.out.printf("substring %s:[%d %d], %s:[%d %d]", left, s, m1, right, m2, e);
        int result;
        if (isPalindrome(left + right)) {
            System.out.println("is palindrome");
            result = -1;
        } else if (left.length() == 1) {
            System.out.format("one left %d v %d\n ", s, m2);
            result = isPalindrome(palindrome.substring(s, m2)) ? m2 : s;
        } else {
            int l = left.length();
            int e1 = l >> 1, s2 = l - (l >> 1);
            result = findIndex(left.substring(0, e1),
                    right.substring(s2, l), s, s + e1 - 1, m2 + s2, e);
            if (result == -1) {
                result = findIndex(left.substring(e1, l),
                        right.substring(0, s2), s + e1, m1, m2, m2 + l - (l >> 1));
            }
        }
        return result;
    }

    private static boolean isPalindrome(String substring) {
        System.out.println();
        StringBuilder sb = new StringBuilder(substring);
        StringBuilder rev = new StringBuilder(substring);
        return String.valueOf(sb).compareTo(String.valueOf(rev.reverse())) == 0;
    }
}


/*
Test cases
fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf
mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm
*/

