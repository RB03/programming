package hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/29/2016.
 */
public class BeautifulBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine());
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            if (sb.substring(i, i + 3).equals("010")) {
                if (i + 5 < len && sb.substring(i + 2, i + 2 + 3).equals("010")) {
                    sb.replace(i + 2, i + 3, "1");
                    count++;
                    i++;
                } else {
                    sb.replace(i + 1, i + 2, "0");
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
