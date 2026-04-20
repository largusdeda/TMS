package homework14.Ex1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    private static final String PATTERN = "[\\p{L}0-9'-]+";

    public static void main(String[] args) {
        String longestWord = findLongestWord();
        writeResult(longestWord);
        System.out.println(longestWord);
    }

    private static String findLongestWord() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src\\homework14\\Ex1\\input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();;
        }

        Matcher matcher = Pattern.compile(PATTERN).matcher(content.toString());

        String longest = "";
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > longest.length())
                longest = word;
        }

        return longest.isEmpty() ? "(нет слов в файле)" : longest;
    }

    private static void writeResult(String result) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src\\homework14\\Ex1\\output.txt"))) {
            bufferedWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
