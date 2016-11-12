package hackerrank.solutions;

import java.util.Scanner;

public class Manacher {
    private int[]  p;  // p[i] = length of longest palindromic substring of t, centered at i
    private String s;  // original string
    private char[] t;  // transformed string

    public Manacher(String s) {
        this.s = s;
        preprocess();
        p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);

            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

    }

    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    // $ and @ are prepended and appended to each end to avoid bounds checking
    private void preprocess() {
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[(s.length() << 1) + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[(i << 1) + 1] = '#';
            t[(i << 1) + 2] = s.charAt(i);
        }
        t[(s.length() << 1) + 1] = '#';
    }

    // longest palindromic substring
    public String longestPalindromicSubstring() {
        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    // longest palindromic substring centered at index i/2
    public String longestPalindromicSubstring(int i) {
        int length = p[i + 2];
        int center = i + 2;
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }



    // test client
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        while (cases-- >0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            Manacher manacher = new Manacher(s1+s2);
            System.out.println(manacher.longestPalindromicSubstring());
//            for (int i = 0; i < 2 * s.length(); i++)
//                System.out.println(i + ": " + manacher.longestPalindromicSubstring(i));
        }
    }
}
