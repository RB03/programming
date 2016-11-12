package hackerrank.solutions;

import java.util.*;

/**
 * Created by Rohit
 * on 7/29/2016.
 */
public class Gemstones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stones= Integer.valueOf(sc.nextLine());
        int tstones= stones;
        HashMap<Character, Set<Integer>> mapping = new HashMap<>();
        while(stones-- >0){
            String elements = sc.nextLine();
            for (int i = 0; i < elements.length(); i++) {
                if (mapping.containsKey(elements.charAt(i))){
                    Set<Integer> cstone = mapping.get(elements.charAt(i));
                    cstone.add(tstones-stones);
                } else {
                    //noinspection ArraysAsListWithZeroOrOneArgument
                    mapping.put(elements.charAt(i), new HashSet<>(Arrays.asList(tstones-stones)));
                }
            }

        }
        long golden = mapping.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(integers -> integers.size()==tstones)
                .count();
        System.out.println(golden);
    }
}
