package CodeWarriors.romanNumsConvertor;

public class RomanNumerals {
    private static final int[] ARABIC_NUMS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // main just for test, can be removed
    public static void main(String[] args) {
        System.out.println(RomanNumerals.toRoman(1666));
        System.out.println(RomanNumerals.toRoman(400));
        System.out.println(RomanNumerals.fromRoman("MDCLXVI"));
        System.out.println(RomanNumerals.fromRoman("CD"));
        System.out.println(RomanNumerals.fromRoman("DC"));
    }

    public static String toRoman(int n) {
        StringBuilder romanResult = new StringBuilder();
        for (int i = 0; i < ARABIC_NUMS.length; i++) {
            while (n >= ARABIC_NUMS[i]){
                romanResult.append(ROMAN_NUMS[i]);
                n -= ARABIC_NUMS[i];
            }
        }
        return romanResult.toString();
    }

    public static int fromRoman(String romanNumeral) {
        int arabicResult = 0;
        for (int i = 0; i < ROMAN_NUMS.length; i++) {
            while (romanNumeral.startsWith(ROMAN_NUMS[i])){
                romanNumeral = romanNumeral.replaceFirst(ROMAN_NUMS[i], "");
                arabicResult += ARABIC_NUMS[i];
            }
        }
        return arabicResult;
    }
}
