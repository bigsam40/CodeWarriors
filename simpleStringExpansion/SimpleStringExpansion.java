package CodeWarriors.simpleStringExpansion;

import java.util.regex.Matcher;

public class SimpleStringExpansion {
    public static void main(String[] args) {
        //System.out.println(solve("3(ab)"));
        System.out.println(solve("2(a3(b))"));
    }

    public static String solve(String s){
        StringBuilder result = new StringBuilder();
        String[] strings = s.split("[()]");
        for (String st:
             strings) {
            System.out.println(st);
            result.append(st);
        }
        return result.toString();
    }
}
