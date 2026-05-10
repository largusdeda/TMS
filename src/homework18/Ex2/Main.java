package homework18.Ex2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(
                1, "Alice",
                2, "Benjamin",
                3, "Charlie",
                4, "David",
                5, "Eva",
                6, "Frank",
                7, "Grace"
        );

        Set<Integer> targetIds = Set.of(1, 2, 5, 8, 9, 13);

        List<String> reversedNames = map.entrySet().stream()
                .filter(e -> targetIds.contains(e.getKey()))
                .filter(e -> e.getValue().length() % 2 != 0)
                .map(e -> new StringBuilder(e.getValue()).reverse())
                .map(StringBuilder::toString)
                .toList();

        System.out.println(reversedNames);
    }
}
