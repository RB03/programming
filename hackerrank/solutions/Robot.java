package hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/22/2016.
 */
public class Robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = Integer.valueOf(scanner.nextLine());

        int F, B, BD, FD, T;
        for (int i = 0; i < N; ++i) {
            F = scanner.nextInt();
            B = scanner.nextInt();
            T = scanner.nextInt();
            FD = scanner.nextInt();
            BD = scanner.nextInt();

            if (FD <= F) {
                System.out.format("%d F\n", FD * T);
            } else {
                if (F > B) {
                    int cur = 0;
                    int time = 0;
                    while (cur + F < FD) {
                        time += (F + B) * T;
                        cur += (F - B);
                    }
                    time += (FD - cur) * T;
                    System.out.format("%d F\n", time);
                } else if (B > F) {
                    int cur = 0;
                    int time = 0;
                    while (cur + B - F < BD) {
                        time += (F + B) * T;
                        cur += (B - F);
                    }
                    time += (BD - cur) * T + 2 * F * T;
                    System.out.format("%d B\n", time);
                } else {
                    System.out.print("No Ditch \n");

                }
            }
        }
    }

}
