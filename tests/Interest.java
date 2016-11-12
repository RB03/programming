package tests;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/22/2016.
 */
public class Interest {
    public static void main(String[] args) {
        Scanner scanner     = new Scanner(System.in);
        BigDecimal amount   = new BigDecimal(scanner.nextDouble()).setScale(11,BigDecimal.ROUND_HALF_UP);
        int period          = scanner.nextInt();
        BigDecimal rate     = new BigDecimal(scanner.nextDouble()/100).setScale(11,BigDecimal.ROUND_HALF_UP);

        BigDecimal n  = new BigDecimal((double)(period-1)/12).setScale(11 , BigDecimal.ROUND_FLOOR);

        BigDecimal principle = (amount.multiply(new BigDecimal(period))).divide(((n.multiply(rate)).add(new BigDecimal(1))), BigDecimal.ROUND_HALF_UP).setScale(0,BigDecimal.ROUND_FLOOR);


        System.out.print(principle.toString());
    }
}
