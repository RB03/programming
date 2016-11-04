package codevita2016;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/29/2016.
 */
public class LogicPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height=scanner.nextInt();

        int current=0;
        int incr=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k < 4; k++) {
                    current= current+incr;
                    incr++;
                }
                System.out.printf("%05d ", current);
            }
            if(i!=height-1)
            System.out.println();
        }
    }
}
