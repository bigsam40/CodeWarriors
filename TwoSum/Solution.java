package CodeWarriors.TwoSum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 4))); // == {0, 2}
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4, 5, 0}, 5))); // == {0, 1}
    }

    /**
     * return null when args are incorrect or no target sum within numbers array
     * @param numbers
     * @param target
     * @return new int[2] contains indices of ints from int[] numbers which sum = target
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
