package homework12.Ex2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        String input = """
                Программа на вход получает произвольный текст. В этом тексте может быть номер
                документа(один или несколько), емейл и номер телефона. Номер документа в формате:
                xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
                может содержать не всю информацию, т.е. например, может не содержать номер
                телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
                формате:
                email: teachmeskills@gmail.com
                document number: 1423-1512-51
                и т.д
                номер телефона: +(22)3344556""";

        String docRegex = "\\b\\d{4}-\\d{4}-\\d{2}";
        String emailRegex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\b";
        String phoneRegex = "\\+\\(\\d{2}\\)\\d{7}";

        System.out.print("email: ");
        findAndPrint(input, emailRegex);
        System.out.println();

        System.out.print("document number: ");
        findAndPrint(input, docRegex);
        System.out.println();

        System.out.print("phone number: ");
        findAndPrint(input, phoneRegex);
        System.out.println();
    }

    private static void findAndPrint(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }

        if (!found)
            System.out.print("Not found");
    }
}
