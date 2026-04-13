package homework10.Ex2;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id пользователя:");
        int userId = scanner.nextInt();
        if (!UserDatabase.userExists(userId)) {
            System.out.println("Ошибка. Пользователь с ID " + userId + " не найден");
            scanner.close();
            return;
        }
        User user = UserDatabase.getUserById(userId);

        System.out.println("Выберите тип клонирования (1 - поверхностное, 2 - глубокое):");
        int cloneType = scanner.nextInt();

        switch (cloneType) {
            case 1:
                CloneDemo.shallowCloneDemo(user);
                break;
            case 2:
                CloneDemo.deepCloneDemo(user);
                break;
            default:
                System.out.println("Ошибка. Неверный ввод");
                break;
        }

        scanner.close();
    }
}
