package homework13.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class UserValidator {
    private static final String LOGIN_PATTERN = "^[^\\s]{1,19}$";
    private static final String PASSWORD_PATTERN = "^(?=.*\\d)[^\\s]{1,19}$";

    public static boolean validate(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login == null || !login.matches(LOGIN_PATTERN))
            throw new WrongLoginException("Логин должен быть меньше 20 символов и не содержать пробелов");

        if (password == null || !password.matches(PASSWORD_PATTERN))
            throw new WrongPasswordException("""
                    Пароль должен быть меньше 20 символов, не содержать пробелов
                    и содержать хотя бы одну цифру""");

        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");

        return true;

    }
}
