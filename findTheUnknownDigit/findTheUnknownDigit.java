package CodeWarriors.findTheUnknownDigit;

import java.util.Arrays;

public class findTheUnknownDigit {

    public static void main(String[] args) {

        System.out.println(solveExpression("1+1=?"));
        System.out.println(solveExpression("1-1=?"));
        System.out.println(solveExpression("123*45?=5?088"));
        System.out.println(solveExpression("-5?*-1=5?"));
        System.out.println(solveExpression("19--45=5?"));
        System.out.println(solveExpression("??*??=302?"));
        System.out.println(solveExpression("?*11=??"));
        System.out.println(solveExpression("??*1=??"));

    }

    public static int solveExpression(final String expression) {
        for (int i = 0; i < 10; i++) {
            if (expression.contains(Integer.toString(i))) continue;

            String expressionChecked = expression.replaceAll("[\\?]", Integer.toString(i));
            expressionChecked = expressionChecked.replaceAll("(--)", "minus-");
            expressionChecked = expressionChecked.replaceAll("((?<=\\d)-(?=\\d))", "minus");

            String[] expressionParts = expressionChecked.split("[+,*,=,]|minus");

            boolean isZeroZero = false;
            for (String s :
                    expressionParts) { //цикл В
                if ("00".equals(s)) isZeroZero = true;
                if ((s.startsWith("0") || s.startsWith("-0")) && s.length() > 1 && !s.equals("-0")) isZeroZero = true;
            }
            if (isZeroZero) continue;

            int[] parsedExpressionParts = new int[3];
            parsedExpressionParts[0] = Integer.parseInt(expressionParts[0]);
            parsedExpressionParts[1] = Integer.parseInt(expressionParts[1]);
            parsedExpressionParts[2] = Integer.parseInt(expressionParts[2]);
            if (expressionChecked.contains("+")) {
                if (parsedExpressionParts[0] + parsedExpressionParts[1] == parsedExpressionParts[2]) {
                    return i;
                }
            } else if (expressionChecked.contains("minus")) {
                if (parsedExpressionParts[0] - parsedExpressionParts[1] == parsedExpressionParts[2]) {
                    return i;
                }
            } else if (expressionChecked.contains("*")) {
                if (parsedExpressionParts[0] * parsedExpressionParts[1] == parsedExpressionParts[2]) {
                    return i;
                }
            } else return -1;
        }
        return -1;
    }
}
