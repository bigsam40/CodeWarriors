package CodeWarriors.accumul;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Accumul {
    public static void main(String[] args) {
        System.out.println(accum("abcd")); // -> "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty")); // -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt")); // -> "C-Ww-Aaa-Tttt"
        System.out.println(accum("sdsd"));
    }
    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        char[] allCh = Arrays.stream(s.split(""))
                .map(s1 -> s1.toLowerCase())
                .collect(Collectors.joining())
                .toCharArray();
        for (int i = 0; i < allCh.length; i++) {
            result.append(String.valueOf(allCh[i]).toUpperCase());
            for (int j = 0; j < i; j++)
                result.append(allCh[i]);
            if (i< allCh.length-1)
                result.append("-");
        }
        return result.toString().trim();
    }
}
