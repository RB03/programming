package hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/24/2016.
 */
public class BiggerGreater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.valueOf(scanner.nextLine());

        while (cases-- > 0){
            char[] inp = scanner.nextLine().toCharArray();
            inp = nextPermutation(inp);
            if (inp == null){
                System.out.println("no answer");
            } else {
                System.out.println(inp);
            }
        }
    }




    public static char[] nextPermutation(char[] array) {
        // Find non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        if (i <= 0)
            return null;

        // Find successor to pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }
}
