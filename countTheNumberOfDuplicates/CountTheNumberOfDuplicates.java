package CodeWarriors.countTheNumberOfDuplicates;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("Indivisibilities"));
        System.out.println(duplicateCount("aA11"));
    }
    public static int duplicateCount(String text) {
        text = text.toLowerCase();

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (Character c :
                text.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else charCountMap.put(c, 1);
        }

        int duplicatesCount = 0;
        for (Character c:
             charCountMap.keySet()) {
            if (charCountMap.get(c) > 1) duplicatesCount++;
        }

        return duplicatesCount;
    }
}
