package CodeWarriors.splitStrings;

import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class StringSplit {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abcdef"))); // => [ab, cd, ef]
        System.out.println(Arrays.toString(solution("abc"))); // => [ab, c_]
        System.out.println(Arrays.toString(solution("32oi490vk{]3-}[3--==+[]\\2-_"))); // => [32, oi, 49, 0v, k{, ]3, -}, [3, --, ==, +[, ]\, 2-, __]
    }

    public static String[] solution(String s) {
        return Pattern.compile(".{2}")
                .matcher((s.length() % 2) == 0 ? s : s+"_")
                .results().map(MatchResult::group)
                .toArray(String[] :: new);
    }
}
