package homework10.Ex2;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Elena Chinarina
 *
 **/

public class UserDatabase {
    private static Map<Integer, User> users = new HashMap<>();

    static {
        Address address1 = new Address("A City by the Light Divided", "Division St");
        List<String> roles1 = Arrays.asList("Admin", "User");
        User user1 = new User(1, "John Doe", "johndoelovesthursday@gmail.com", 99, address1, roles1);

        Address address2 = new Address("San Andreas", "Grove St");
        List<String> roles2 = List.of("User");
        User user2 = new User(2, "Carl Johnson", "cj@gmail.com", 24, address2, roles2);

        users.put(1, user1);
        users.put(2, user2);
    }

    public static User getUserById(int id) {
        return users.get(id);
    }

    public static boolean userExists(int id) {
        return users.containsKey(id);
    }
}
