package homework16.Ex2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> result = new HashMap<>();

        for (String string : strings) {
            if (string != null && !string.isBlank()) {
                String key = String.valueOf(string.charAt(0));
                String value = String.valueOf(string.charAt(string.length() - 1));
                result.put(key, value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input1 = {"code", "bug"};
        System.out.println(pairs(input1));
        String[] input2 = {"man", "moon", "main"};
        System.out.println(pairs(input2));
    }
}
