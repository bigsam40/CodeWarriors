package CodeWarriors.EqualSidesOfAnArray;


public class EqualSidesOfAnArray {
    // for test
    public static void main(String[] args) {

    }

    public static int findEvenIndex(int[] arr) {
        if (arr.length < 1) return -1;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int j = i-1; j >= 0; j--) {
                leftSum += arr[j];
            }
            int rightSum = 0;
            for (int j = i+1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
