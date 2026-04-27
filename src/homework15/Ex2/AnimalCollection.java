package homework15.Ex2;

import java.util.LinkedList;

/**
 * @author Elena Chinarina
 *
 **/

public class AnimalCollection {
    private LinkedList<String> animals;

    public AnimalCollection() {
        animals = new LinkedList<>();
    }

    public void addAnimal(String animal) {
        if (animal == null || animal.trim().isEmpty()) {
            System.out.println("Название животного не может быть пустым");
            return;
        }

        animals.addFirst(animal);
        System.out.println("Добавлено животное \"" + animal + "\"");
    }

    public String removeAnimal() {
        if (animals.isEmpty()) {
            System.out.println("Коллекция пуста, нечего удалять");
            return null;
        }

        return animals.removeLast();
    }

    public void displayAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Коллекция пуста");
            return;
        }

        System.out.println("Текущая коллекция:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i));
        }
    }

    public int size() {
        return animals.size();
    }

    public boolean isEmpty() {
        return animals.isEmpty();
    }

    public String getFirst() {
        if (animals.isEmpty())
            return null;
        return animals.getFirst();
    }

    public String getLast() {
        if (animals.isEmpty())
            return null;
        return animals.getLast();
    }
}
