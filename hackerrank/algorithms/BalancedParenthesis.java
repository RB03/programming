package hackerrank.algorithms;

import java.util.*;

/**
 * Created by Rohit
 * on 7/22/2016.
 */
public class BalancedParenthesis {
    private static final List<Character> opening = Arrays.asList('{' , '<' , '[' , '(');
    private static final List<Character> closing = Arrays.asList('}' , '>' , ']' , ')');

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);


        while (scanner.hasNext()) {
            String input=scanner.next();
            Stack<Character> parenthesis = new Stack<>();

            int len = input.length();

            if (len%2 != 0){
                System.out.println("false");
                continue;
            }

            boolean isValid = true;
            for (int i = 0; i <len; i++) {
                char brace = input.charAt(i);

                if (isClose(brace) && parenthesis.isEmpty()){
                    isValid=false;
                    break;
                }

                if (isOpen(brace)) parenthesis.push(brace);
                else if (isClose(brace) && (openEquivalent(brace) == parenthesis.peek())){
                    parenthesis.pop();
                } else if (isClose(brace) && (openEquivalent(brace) != parenthesis.peek())){
                    isValid=false;
                    break;
                }
            }
            if (isValid && parenthesis.isEmpty()) System.out.println("true");
            else System.out.println("false");

        }

    }

    private static Character openEquivalent(char brace) {
        return opening.get(closing.indexOf(brace));
    }

    private static boolean isClose(char brace) {
        return closing.contains(brace);
    }
    private static boolean isOpen(char brace){
        return opening.contains(brace);
    }
}
