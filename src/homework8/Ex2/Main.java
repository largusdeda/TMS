package homework8.Ex2;

import java.lang.reflect.Field;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Apple originallyGreenApple = new Apple("зеленый");
        System.out.println("Текущий цвет яблока: " + originallyGreenApple.getColor());

        try {
            Field field = originallyGreenApple.getClass().getDeclaredField("color");
            field.setAccessible(true);
            field.set(originallyGreenApple, (String) "красный");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Текущий цвет яблока: " + originallyGreenApple.getColor());

    }
}
