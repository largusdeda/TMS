package homework11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Elena Chinarina
 *
 **/

public class StringUtils {
    private StringUtils() {}

    public static boolean hasAllUniqueChars(String word) {
        if (word == null || word.isEmpty())
            return false;

        Set<Character> characterSet = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (characterSet.contains(c))
                return false;
            characterSet.add(c);
        }

        return true;
    }

    public static String findFirstUniqueWord(String... strings) {
        for (String line : strings) {
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (StringUtils.hasAllUniqueChars(word)) {
                    return word;
                }
            }
        }

        return null;
    }

    public static String duplicateCharacters(String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            result.append(currentChar).append(currentChar);
        }

        return result.toString();
    }

    public static boolean isPalindrome(String word) {
        if (word == null || word.isBlank())
            return false;


        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.toLowerCase().charAt(left) != word.toLowerCase().charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
