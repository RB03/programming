package hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/23/2016.
 */
public class CamelCase {
    public static void main(String[] args) {
        String sentence= new Scanner(System.in).nextLine();
        int length  = sentence.length();
        int count = 1;
        for (int i = 0; i < length; i++) {
            char t= sentence.charAt(i);
            if (t >= 'A' && t <='Z' ) count ++;
        }
        System.out.println(count);
    }
}
