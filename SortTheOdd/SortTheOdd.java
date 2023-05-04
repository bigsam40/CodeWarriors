package CodeWarriors.SortTheOdd;

import java.util.ArrayList;
import java.util.Arrays;
public class SortTheOdd {
    // for tests
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }

    public static int[] sortArray(int[] array) {
        int[] resultArr = array.clone(); //in order to not corrupt the input data
        ArrayList<Integer> oddList = new ArrayList<>(Arrays.stream(resultArr).boxed().filter(value -> value % 2 != 0).sorted().toList());
        for (int i = 0; i < resultArr.length; i++) {
            if (resultArr[i]%2 != 0){
                resultArr[i] = oddList.get(0);
                oddList.remove(0);
            }
        }
        return resultArr;
    }
}
