package hackerrank.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/7/2016.
 */
public class JesseAndProfit {
    static HashMap<Integer, int[]> profits = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt(); scanner.nextLine();
        String stockValues = scanner.nextLine();

        initProfits(stockValues);
//        System.out.println(profits.toString());

        while (D-- > 0){
//            amnt = scanner.nextInt();
            int[] t = profits.get(scanner.nextInt());
            if (t != null) {
                System.out.printf("%d %d\n", t[0]+1, t[1]+1);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static void initProfits(String stockValues) {
        int profit;
        stockValues = stockValues.replaceAll("\\s", "");
//        System.out.printf(stockValues);
        for (int i = 0; i < stockValues.length() - 1; i++) {
            for (int j = i + 1; j < stockValues.length(); j++) {
//                System.out.println(stockValues.charAt(j));
                profit = (int) stockValues.charAt(j) - (int) stockValues.charAt(i);

                if (profit > 0){
                    int [] t;
                    if (!profits.containsKey(profit)) {
                        profits.put(profit, new int[]{i,j});
                    } else {
                        t = profits.get(profit);
                        if (t[1] - t[0] > j- i ){
                            t[0] = i; t[1] =j;
                            profits.put(profit, t);
                        }
                    }
                }
            }
        }
    }
}
