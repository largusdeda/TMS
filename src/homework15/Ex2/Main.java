package homework15.Ex2;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main (String[] args) {
        AnimalCollection animalCollection = new AnimalCollection();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Добавить животное (в начало)");
            System.out.println("2. Удалить животное (из конца)");
            System.out.println("3. Показать всех животных");
            System.out.println("0. Выход");
            System.out.println("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите название животного:");
                    String animal = scanner.nextLine();
                    animalCollection.addAnimal(animal);
                    break;
                case 2:
                    String removed = animalCollection.removeAnimal();
                    if (removed != null)
                        System.out.println("Удалено \"" + removed + "\"");
                    break;
                case 3:
                    animalCollection.displayAnimals();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }

        scanner.close();
    }
}
