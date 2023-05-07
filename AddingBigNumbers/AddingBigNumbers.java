package CodeWarriors.AddingBigNumbers;

public class AddingBigNumbers {
    public static void main(String[] args) {
        System.out.println(add("123", "321")); //-> "444"
        System.out.println(add("11", "98"));  // -> "110"
        System.out.println(add("90938498237058927340892374089",
                               "91002328220491911630239667963"));
        System.out.println(add("04198606835547471381119199177673", "818105307461258116690"));
        System.out.println(add("0", "1548"));
    }

    public static String add(String a, String b) {
        StringBuilder first = new StringBuilder(a).reverse();
        StringBuilder second = new StringBuilder(b).reverse();
        StringBuilder result = new StringBuilder();
        int modulo = 0;
        while (!first.isEmpty() || !second.isEmpty()){
            int x = 0;
            int y = 0;
            if (first.length() > 0) {
                x = Integer.parseInt(first.substring(0, 1));
                first.deleteCharAt(0);
            }
            if (second.length() > 0) {
                y = Integer.parseInt(second.substring(0, 1));
                second.deleteCharAt(0);
            }
            int sum = x + y + modulo;
            result.append(sum % 10);
            modulo = sum / 10;
        }
        if (modulo > 0) result.append(modulo);
        return result.reverse().toString().replaceAll("^0+", "");
    }
}
