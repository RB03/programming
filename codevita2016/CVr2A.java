package codevita2016;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 8/19/2016.
 */
public class CVr2A {
    private static HashMap<String, Integer> players= new HashMap<>();


    static  int playerAScore;
    static  int playerBScore;
    private static String playerNameA = " ";
    private static String playerNameB = "";
    private static boolean sameplayer = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t3 = sc.nextLine(); t3=t3.trim();

        if (!isInteger(t3, 10)) invalidInput();
        int N = Integer.valueOf(t3);

        if (N <= 1 || N > 10){
            invalidInput();
        }

        String pa;
        String pb;
        String salq = null;

        for (int i = N; i > 0; i= i - 2){

            if (i == 1 || N > 10){
                invalidInput();
            }

            String inp[] = sc.nextLine().split(" ");
            if (inp.length != 2) invalidInput();

            pa = inp[0];
            if (!players.containsKey(pa)){
                players.put(pa, 0);
                playerNameA = pa;
            }
            String s = inp[1];

            String set[] = null;
            if (Character.isDigit(s.charAt(0))){
                set = s.split(",");

                if (set.length < 2 || set.length > 7) invalidInput();

                for (String t : set) {
                    if (!isInteger(t , 10)) invalidInput();
                    if (Integer.valueOf(t) < 1 || Integer.valueOf(t) > 100) invalidInput();
                }

                salq = pa + "'s " + "question is: "+ s;
//                System.out.println(pa+ "'s " + "question is: "+ s);

            } else {
                invalidInput();
            }

            long answer = lcm(set);

            String t2[] = sc.nextLine().split(" ");
            if(t2.length != 3 ) invalidInput();
            String ans = t2[2];

            if (t2[0].equals("A")){

                pb = t2[1];
                if (pb.equals(pa)) {
//                    sameplayer = true;
                    invalidInput();
                } else if (sameplayer = true){
                    invalidInput();
                }

                if (!players.containsKey(pb)){
                    players.put(pb, 0);
                    playerNameB = pb;
                }


                if (ans.equals("PASS")){
                    System.out.println(salq);
                    System.out.println("Question is PASSed");
                    System.out.println("Answer is: " + answer);
                    System.out.println(pb + ": 0points");

                } else if (isInteger(ans, 10)) {
                    if (Integer.valueOf(ans) == answer){
                        System.out.println(salq);
                        System.out.println("Correct Answer");
                        System.out.println(pb + ": 10points");
                        players.put(pb, players.get(pb) + 10);
                    } else {
                        System.out.println(salq);
                        System.out.println("Wrong Answer");
                        System.out.println(pb + ": 0points");
                    }
                } else invalidInput();
            } else invalidInput();
        }

        printResult();

    }

    private static void printResult() {
        if (sameplayer){
            System.out.println("Total Points:");
            System.out.println(playerNameA +": " + players.get(playerNameA) + "points");
            System.out.println(playerNameA +": " + players.get(playerNameA) + "points");

            int scoreA = players.get(playerNameA);
            int scoreB = players.get(playerNameA);
            if (scoreA > scoreB) {
                System.out.print("Game Result: " +playerNameA+ " is winner");
            } else if (scoreA < scoreB){
                System.out.print("Game Result: " +playerNameA+ " is winner");
            } else {
                System.out.print("Game Result: Draw");
            }
            System.exit(0);

        }

        System.out.println("Total Points:");
        System.out.println(playerNameA +": " + players.get(playerNameA) + "points");
        System.out.println(playerNameB +": " + players.get(playerNameB) + "points");

        int scoreA = players.get(playerNameA);
        int scoreB = players.get(playerNameB);
        if (scoreA > scoreB) {
            System.out.print("Game Result: " +playerNameA+ " is winner");
        } else if (scoreA < scoreB){
            System.out.print("Game Result: " +playerNameB+ " is winner");
        } else {
            System.out.print("Game Result: Draw");
        }

    }



    private static void invalidInput() {
        System.out.print("Invalid Input");
        System.exit(0);
    }


    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    private static long lcm(String[] input)
    {
        long result = Long.valueOf(input[0]);
        for(int i = 1; i < input.length; i++) result = lcm(result, Long.valueOf(input[i]));
        return result;
    }

    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static boolean isInteger(String s, int radix) {
        Scanner sc = new Scanner(s.trim());
        if(!sc.hasNextInt(radix)) return false;

        sc.nextInt(radix);
        return !sc.hasNext();
    }
}
