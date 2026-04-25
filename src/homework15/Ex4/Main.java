package homework15.Ex4;

import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("=== <String> ===");

            CustomArrayList<String> list = new CustomArrayList<>();

            list.add("Apple");
            list.add("Banana");
            list.add("Blueberry");

            System.out.println("List: " + list);

            // for-each loop
            System.out.println("\n--- for-each loop:");
            for (String fruit : list) {
                System.out.println("Fruit: " + fruit);
            }

            // iterator
            System.out.println("\n--- iterator");
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String fruit = iterator.next();
                System.out.println("Element: " + fruit);

                if (fruit.equals("Blueberry")) {
                    System.out.println("Delete \"Blueberry\"");
                    iterator.remove();
                    System.out.println("Deleted: " + fruit);
                }
            }

            list.add(2, "Watermelon");

            System.out.println("\nList: " + list);

            System.out.println("Element at index 0: " + list.get(0));

            // contains & remove "Apple"
            if (list.contains("Apple"))
                list.remove("Apple");
            System.out.println("\nList: " + list);
        }

        {
            System.out.println("\n=== <Integer> ===");

            CustomArrayList<Integer> list = new CustomArrayList<>(2);
            list.add(1);
            list.add(2);

            System.out.println("List size: " + list.size());

            list.add(3);
            System.out.println("List size: " + list.size() + ", List capacity: " + getCapacity(list));

            System.out.println("List: " + list);

            //forEach method
            System.out.println("\nforEach method");
            list.forEach(number -> System.out.println("-> " + number));

            //forEachRemaining method
            System.out.println("\nforEachRemaining method");
            Iterator<Integer> iterator = list.iterator();
            iterator.forEachRemaining(number -> System.out.println("Remaining: " + number));

            // remove at index
            list.remove(1);
            System.out.println("\nList: " + list);

            // set at index
            list.set(0, 99);
            System.out.println("List: " + list);

            // size vs capacity
            // trimToSize()
            list.add(0);
            list.add(0);
            list.add(0);
            list.add(0);
            list.add(0);
            list.add(0);
            list.add(0);
            System.out.println("\nList size: " + list.size() + ", List capacity: " + getCapacity(list));

            list.clear();
            System.out.println("List size: " + list.size() + ", List capacity: " + getCapacity(list));

            list.trimToSize();
            System.out.println("List size: " + list.size() + ", List capacity: " + getCapacity(list));
        }
    }

    public static int getCapacity(CustomArrayList<?> customArrayList) {
        try {
            Field field = CustomArrayList.class.getDeclaredField("elements");
            field.setAccessible(true);
            Object[] elements = (Object[]) field.get(customArrayList);
            return elements.length;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
