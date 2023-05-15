package CodeWarriors.TheObservedPIN;

import java.util.*;

public class TheObservedPIN {
    //for tests
    public static void main(String[] args) {
        System.out.println(getPINs("4589"));
        System.out.println(getPINs("007"));
        System.out.println(getPINs("08628405"));
    }

    public static List<String> getPINs(String observed) {
        if (observed == null || observed.length() < 1 || observed.length() > 8) {
            throw new RuntimeException("oops, observe is invalid");
        }
        List<Integer> observedPass = Arrays.stream(observed.split("")).map(Integer::parseInt).toList();
        Map<Integer, int[]> possibleDigitsForEachPos = new TreeMap<>(); //for code 6589 6 - firstPos, 5 - secondPos etc.
        for (int i = 0; i < observedPass.size(); i++) {
            if (observedPass.get(i) == 1){
                possibleDigitsForEachPos.put(i, new int[] {1,2,4});
            }else if (observedPass.get(i) == 2){
                possibleDigitsForEachPos.put(i, new int[] {2,1,5,3});
            }else if (observedPass.get(i) == 3){
                possibleDigitsForEachPos.put(i, new int[] {3,2,6});
            }else if (observedPass.get(i) == 4){
                possibleDigitsForEachPos.put(i, new int[] {4, 1,5,7});
            }else if (observedPass.get(i) == 5){
                possibleDigitsForEachPos.put(i, new int[] {5, 2,4,6,8});
            }else if (observedPass.get(i) == 6){
                possibleDigitsForEachPos.put(i, new int[] {6,5,3,9});
            }else if (observedPass.get(i) == 7){
                possibleDigitsForEachPos.put(i, new int[] {7,4,8});
            }else if (observedPass.get(i) == 8){
                possibleDigitsForEachPos.put(i, new int[] {8,7,5,9,0});
            }else if (observedPass.get(i) == 9){
                possibleDigitsForEachPos.put(i, new int[] {9,8,6});
            }else if (observedPass.get(i) == 0){
                possibleDigitsForEachPos.put(i, new int[] {0,8});
            }
        }
        List<String> allCombinations = new ArrayList<>();
        genAllCombs(possibleDigitsForEachPos, new int[observed.length()], 0, allCombinations);
        return allCombinations;
    }

    private static void genAllCombs(Map<Integer, int[]> possibleDigitsForEachPos,
                                             int[] comb,
                                             int combIndex,
                                             List<String> allCombinations) {
        if (combIndex == comb.length) {
            StringBuilder sb = new StringBuilder();
            for (int d : comb) {
                sb.append(d);
            }
            allCombinations.add(sb.toString());
            return;
        }
        // else
        for (int i = 0; i < possibleDigitsForEachPos.get(combIndex).length; i++) {
            comb[combIndex] = possibleDigitsForEachPos.get(combIndex)[i];
            genAllCombs(possibleDigitsForEachPos, comb, combIndex + 1, allCombinations);
        }
    }
}
