package hackerrank.euler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Rohit
 * on 10/18/2016.
 */
public class LargestProductInAGrid {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int[][] grid = new int[23][26];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 26; j++) {
             grid[i][j] = 0;
            }
            for (int j = 0; j < 23; j++) {
                grid[j][i] = 0;
                grid[j][25-i] = 0;
            }
        }

        for (int i = 3; i < 23; i++) {
            for (int j = 3; j < 23; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int max = 0;
        int[] values = new int[4];
        for (int i = 3; i < 23; i++) {
            for (int j = 3; j < 23; j++) {
                Arrays.fill(values ,1);
                for (int k = 0; k < 4; k++) {
                    values[0] *= grid[i-k][j];
                    values[1] *= grid[i][j-k];
                    values[2] *= grid[i-k][j-k];
                    values[3] *= grid[i-k][j+k];
                }

                int t = Arrays.stream(values).max().getAsInt();
                max = max < t ? t : max;
            }
        }

        System.out.println(max);

    }
}
