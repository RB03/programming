package hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/29/2016.
 */
public class RecurringCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());

        while (cases-- > 0){
            String input = sc.nextLine();
            int cost=0;
            for (int i = 0; i < input.length()-1; i++) {
                if (input.charAt(i) == input.charAt(i+1)){
                    cost++;
//                    char t= input.charAt(i);
//                    int j=i+1;
//                    while (input.charAt(j) == t && j< input.length()-1) {
//                        j++;
//                    }
//                    cost= cost+j-i-1;
//                    i=j+1;
                }
            }
            System.out.println(cost);
        }
    }
}
