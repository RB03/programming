package hackerrank.solutions;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/31/2016.
 */
public class EqualStacks {
    private class Pile{
        LinkedList<Integer> stack;
        int size=0;

        Pile() {
           stack= new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(); int n2 = in.nextInt(); int n3 = in.nextInt();
        Pile pileA= new EqualStacks().new Pile();
        for(int h1_i=0; h1_i < n1; h1_i++){
            int t = in.nextInt();
            pileA.stack.add(t);
            pileA.size += t;
        }
        Pile pileB= new EqualStacks().new Pile();
        for(int h1_i=0; h1_i < n1; h1_i++){
            int t = in.nextInt();
            pileB.stack.add(t);
            pileB.size += t;
        }
        Pile pileC= new EqualStacks().new Pile();
        for(int h1_i=0; h1_i < n1; h1_i++){
            int t = in.nextInt();
            pileC.stack.add(t);
            pileC.size += t;
        }
        new EqualStacks().run(pileA, pileB, pileC);
    }

    private void run(Pile pileA, Pile pileB, Pile pileC) {
        while(!allEqual(pileA.size, pileB.size, pileC.size)){

        }
    }

    private boolean allEqual(int pileA, int pileB, int pileC) {
        return pileA == pileB && (pileB == pileC);
    }
}
