package homework16.Ex1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> result = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (String string : strings) {
            count.put(string, count.getOrDefault(string, 0) + 1);
            result.put(string, count.get(string) >= 2);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input1 = {"a", "b", "a", "c", "b"};
        System.out.println(wordMultiple(input1));
        String[] input2 = {"c", "c", "c"};
        System.out.println(wordMultiple(input2));
    }
}
