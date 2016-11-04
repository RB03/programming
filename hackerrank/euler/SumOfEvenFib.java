package hackerrank.euler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/31/2016.
 */
public class SumOfEvenFib {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0){
            ArrayList<Long> f = new ArrayList<>();
            f.add(0L);
            f.add(2L);
            Long N = scanner.nextLong();

            long sum = 2;

            int i = 2;
            while (true) {
                long fib = (f.get(i-1)<<2) + f.get(i-2);
                if (fib <= N){
                    sum += fib;
                    f.add(fib);
                }else {
                    System.out.println(sum);
                    break;
                }
                i++;
            }


        }
    }
}
