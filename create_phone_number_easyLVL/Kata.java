package CodeWarriors.create_phone_number_easyLVL;

public class Kata {
    //main method for test
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(createPhoneNumber(new int[]{9, 7, 8, 7, 5, 5, 7, 5, 5, 0}));
    }

    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%s%s%s) %s%s%s-%s%s%s%s", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }
}