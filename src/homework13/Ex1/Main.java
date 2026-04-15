package homework13.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        // все ок
//        String login = "user123";
//        String password = "password123";
//        String confirmPassword = "password123";

        // некорректный логин
//        String login = "user 123";
//        String password = "password123";
//        String confirmPassword = "password123";

        // некорректный пароль
//        String login = "user123";
//        String password = "password";
//        String confirmPassword = "password";

        // пароли не совпадают
        String login = "user123";
        String password = "password123";
        String confirmPassword = "password1123";

        try {
            System.out.println(UserValidator.validate(login,password, confirmPassword));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
