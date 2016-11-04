package hackerrank.algorithms;

import java.util.*;

public class Pangram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] sink = new boolean[26];
        String inp = scanner.nextLine();
        int len = inp.length();
        char t;
        int unique = 0;
        for (int i = 0; i < len && unique < 26; i++) {
            t = inp.charAt(i);
            if (t != ' ') {
                if (t >= 'a' && t <= 'z') {
                    if (!sink[t - 'a']) {
                        sink[t - 'a'] = true;
                        unique++;
                    }
                } else {
                    if (!sink[t - 'A']) {
                        sink[t - 'A'] = true;
                        unique++;
                    }
                }

            }
        }

        if (unique != 26) {
            System.out.print("not panagram");
        } else {
            System.out.print("panagram");
        }
    }
}