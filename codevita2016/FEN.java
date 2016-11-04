package codevita2016;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Rohit
 * on 7/29/2016.
 */
public class FEN {
    private static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> moveList = new ArrayList<>();
        char[][] positions = new char[8][8];
        ArrayList<String> bishopPositions =new ArrayList<>();

        String[] fen = scanner.next().split("/");
        String toMove = scanner.next();

        char bToMove = toMove.toCharArray()[0]=='w'? 'B'  : 'b';
        for (int i = 0; i < 8; i++) {
            if(fen[i].length()>1){
                int col=0;
                for (int j = 0; j < fen[i].length(); j++) {
                    char t= fen[i].charAt(j);
//                    System.out.println(t);
                    if((t>='a' && t <= 'z') || (t>='A' && t <= 'Z')){
                        if (t==bToMove){
                            bishopPositions.add(i+""+col);
                        }
                        positions[i][col]=t;
                        col++;
                    } else {
                        for (int k = 0; k < Character.getNumericValue(t); k++) {
//                            System.out.println("putting 0");
                            positions[i][col] = '0';
                            col++;
                        }
                    }
                }
            } else {
                for (int j =0; j<8; j++){
                    positions[i][j]='0';
                }
            }
        }

        char[] bdp = new char[2];
        bdp[0]='x';
        bdp[1]='y';
        for (int i = 0; i < bishopPositions.size(); i++) {

            int bi = Character.getNumericValue(bishopPositions.get(i).charAt(0));
            int bj = Character.getNumericValue(bishopPositions.get(i).charAt(1));

            int t1=bi-1, t2=bj-1;
            while (t1>=0 && t2 >=0){
                if (positions[t1][t2]=='0' || positions[t1][t2]==bdp[0] || positions[t1][t2]==bdp[1]){
                    positions[t1][t2]=bdp[i];
                    t1--;
                    t2--;
                } else break;
            }
            t1=bi-1; t2=bj+1;
            while (t1>=0 && t2 <8){
                if (positions[t1][t2]=='0' || positions[t1][t2]==bdp[0] || positions[t1][t2]==bdp[1]){
                    positions[t1][t2]=bdp[i];
                    t1--;
                    t2++;
                } else break;
            }
            t1=bi+1; t2=bj-1;
            while (t1<8 && t2 >=0){
                if (positions[t1][t2]=='0' || positions[t1][t2]==bdp[0] || positions[t1][t2]==bdp[1]){
                    positions[t1][t2]=bdp[i];
                    t1++;
                    t2--;
                } else break;
            }
            t1=bi+1; t2=bj+1;
            while (t1<8 && t2 <8){
                if (positions[t1][t2]=='0' || positions[t1][t2]==bdp[0] || positions[t1][t2]==bdp[1]){
                    positions[t1][t2]=bdp[i];
                    t1++;
                    t2++;
                } else break;
            }

            char bxi= (char) ('a' +bj);
            int bxj=  8-bi;
            for (int f = 0; f < 8; f++) {
                for (int f1 = 0; f1 < 8; f1++) {
                    if (positions[f][f1]==bdp[i]){

                        char pp = (char) ('a'+f1);
                        int pp2 = (8-f);
                       result.add(String.valueOf(bxi)+String.valueOf(bxj)+
                               String.valueOf(pp)+String.valueOf(pp2));
                    }
                }
            }
        }

//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.printf("%c ", positions[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(result.toString());


    }


}
