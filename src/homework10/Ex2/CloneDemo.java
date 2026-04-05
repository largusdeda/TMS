package homework10.Ex2;

/**
 * @author Elena Chinarina
 *
 **/

public class CloneDemo {
    public static void deepCloneDemo(User user) {
        try {
            User cloned = new User(user);
            System.out.println("До изменений:");
            System.out.println("Оригинал: " + user);
            System.out.println("Клон: " + cloned);

            cloned.setUsername("Clone-" + cloned.getUsername());
            cloned.getRoles().add("Moderator");
            cloned.getAddress().setStreet("Cloned " + cloned.getAddress().getStreet());

            System.out.println();
            System.out.println("После изменений:");
            System.out.println("Оригинал: " + user);
            System.out.println("Клон: " + cloned);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    public static void shallowCloneDemo(User user) {
        try {
            User cloned = user.clone();
            System.out.println("До изменений:");
            System.out.println("Оригинал: " + user);
            System.out.println("Клон: " + cloned);

            cloned.setUsername("Clone-" + cloned.getUsername());
            cloned.getRoles().add("Moderator");
            cloned.getAddress().setStreet("Cloned " + cloned.getAddress().getStreet());

            System.out.println();
            System.out.println("После изменений:");
            System.out.println("Оригинал: " + user);
            System.out.println("Клон: " + cloned);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
