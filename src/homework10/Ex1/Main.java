package homework10.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        User user1 = new User("aaa", "aaa@gmail.com", 99);
        User user2 = new User("aaa", "aaa@gmail.com", 99);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println("user1 == user2: " + (user1 == user2));
        System.out.println("user1.equals(user2): " + user1.equals(user2));
        System.out.println("user1.hashCode: " + user1.hashCode());
        System.out.println("user2.hashCode: " + user2.hashCode());
    }
}
