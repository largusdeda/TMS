package homework16.Ex3;

import java.util.*;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static boolean isBalanced(String str) {
        if (str == null || str.isEmpty())
            return true; // пустая строка считается сбалансированной

        Stack<Character> characterStack = new Stack<>();

        // сопоставление закрывающих скобок с открывающими
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        // множество открывающих скобок для проверки
        Set<Character> openBrackets = new HashSet<>(Arrays.asList('(', '{', '['));

        for (char ch : str.toCharArray()) {
            if (openBrackets.contains(ch)) { // если скобка открывающая - поместить ее в стек
                characterStack.push(ch);
            } else if (brackets.containsKey(ch)) { // если скобка закрывающая
                if (characterStack.isEmpty() || characterStack.pop() != brackets.get(ch))
                    // если стек пуст или верхняя скобка не соответствует
                    return false;
            }
        }

        // строка сбалансирована, если стек пуст
        return characterStack.isEmpty();
    }
    public static void main(String[] args) {
        String[] cases = {
                "()",
                "[()]",
                "{{()[]}}}}",
                "{([)]",
                "(",
                "",
                "([{{[(())]}}])"
        };

        for (String string : cases) {
            System.out.println("\"" + string + "\" -> " + isBalanced(string));
        }
    }
}
