package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/31/2016.
 */
public class MultipleOf3n5 {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int cases =scanner.nextInt(); scanner.nextLine();
        while (cases-- > 0){
            long n = scanner.nextLong();
            long three = (n-1)/3;
            long five = (n-1)/5;
            long fifteen = (n-1)/15;
            System.out.println(sumOfMultiples(three, five, fifteen));
        }
    }

    private static long sumOfMultiples(long three, long five, long fifteen) {

        return (3L*(three*(three+1L))>>1) + (5L*(five*(five+1L))>>1) - (15L*(fifteen*(fifteen+1L))>>1);
    }
}
