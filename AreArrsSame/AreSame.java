package CodeWarriors.AreArrsSame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AreSame {
    //main for test
    public static void main(String[] args) {
        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));
        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361}));
        System.out.println(comp(new int[]{1, 2},
                new int[]{1}));
    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) return false;
        List<String> checkList = Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.toList());
        for (int i : a) {
            String pow = String.valueOf(i * i);
            if (checkList.contains(pow)) checkList.remove(pow);
            else return false;
        }
        return true;
    }
}
