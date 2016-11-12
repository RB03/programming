package hackerrank.solutions;

import java.util.*;

/**
 * Created by Rohit
 * on 8/7/2016.
 */

/*
morgan stanley 2016

Sample Input
6 2
3 1 2 1 4 5
3
2

Sample Output
4 5
3 5

Explanation
To achieve a profit of 3, he can either buy on day 2 or day 4 and sell on day 5 or he can buy on day 3 and sell on day 6. The one that takes the minimum number of days is the one where he buys on day 4 and sells on day 5. So the answer is 4 5.
 */

public class JesseAndProfit {
    static HashMap<Long, ArrayList<Integer>> profits = new HashMap<>();
    static ArrayList<Long> val = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        scanner.nextLine();
        long l;
        for (int i = 0; i < N; i++) {
            l = scanner.nextLong();
            val.add(l);
            if (profits.containsKey(l)){
                profits.get(l).add(i);
            } else {
                profits.put(l , new ArrayList<>(Arrays.asList(i)));
            }
        }

        scanner.nextLine();
        while ( D-- > 0){
            ArrayList<Integer> pos = null;
            long min = Long.MAX_VALUE;
            boolean found = false;
            int[] t = new int[2];

            long d = scanner.nextLong();
            for (int i = 0; i < val.size(); i++) {
                pos = profits.get(val.get(i) + d);
                if (pos != null){
                    for (int k : pos) {
                        if (k > i && k - i < min) {
                                min = k - i;
                                t = new int[]{i+1, k+1};
                                found = true;
                        }
                    }
                }
            }
            if (found) {
                System.out.printf("%d %d\n",t[0],t[1]);
            } else System.out.println(-1);
        }

//        String stockValues =scanner.nextLine().replaceAll("\\s","");


    }
}