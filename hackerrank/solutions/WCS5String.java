package hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/23/2016.
 */
public class WCS5String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        while (cases-- >0){
            int cost =0;
            int [] sink= new int[26];
            String sentence = sc.nextLine();
            int length = sentence.length();

            for (int i = 0; i < length; i++) {
                char t = sentence.charAt(i);
                if (sink[t-'a']!=1){
                 sink[t-'a']=1; cost++;
                }
            }
        System.out.println(cost);

        }
    }
}
