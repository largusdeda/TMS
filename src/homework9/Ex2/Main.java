package homework9.Ex2;

import sun.misc.Unsafe;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        SingletonDog originalDog = SingletonDog.getInstance("Собака");
        originalDog.voice();

        //SingletonDog dog2 = new SingletonDog("Собака 2");
        SingletonDog notAnotherOriginalDog = SingletonDog.getInstance("Собака 2?");
        notAnotherOriginalDog.voice();

        System.out.println("originalDog == notAnotherOriginalDog: " + (originalDog == notAnotherOriginalDog));

        System.out.println();

        //рефлексия
        try {
            Constructor<SingletonDog> constructor = SingletonDog.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            SingletonDog dog2 = constructor.newInstance("Собака 2");
            System.out.println("originalDog == dog2: " + (originalDog == dog2));
            dog2.voice();
        } catch (InvocationTargetException | NoSuchMethodException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println();

        /************* мне захотелось попробовать найденные в интернете другие методы *************/

        //с помощью unsafe
        try {
            //получение экземпляра unsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
//            //или
//            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            Unsafe unsafe = constructor.newInstance();

            //создание объекта класса без вызова конструктора
            SingletonDog dog3 = (SingletonDog) unsafe.allocateInstance(SingletonDog.class);

            System.out.println("originalDog == dog3: " + (originalDog == dog3));

            //инициализация и установка значения поля
            Field nameField = Animal.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(dog3, "Собака 3"); //чтобы поле name не было =null

            //вызов метода
            dog3.voice();
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
//        catch (NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

        System.out.println();

        //через reflection factory
        try {
            //для создания объекта кастомного конструктора
            ReflectionFactory rf = ReflectionFactory.getReflectionFactory();

            //получение конструктора Object, который есть всегда
            Constructor<Object> objectConstructor = Object.class.getDeclaredConstructor();

            //создание конструктора для SingletonDog,
            //который будет использовать конструктор Object
            Constructor<?> customConstructor = rf.newConstructorForSerialization(
                            SingletonDog.class, //для какого класса создать конструктор
                            objectConstructor   //какой конструктор использовать для выделения памяти
            );

            //создание экземпляра без вызова конструктора SingletonDog()
            SingletonDog dog4 = (SingletonDog) customConstructor.newInstance();

            System.out.println("originalDog == dog4: " + (originalDog == dog4));

            //инициализация и установка значения поля
            Field nameField = Animal.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(dog4, "Собака 4");


            //вызов метода
            dog4.voice();
        } catch (NoSuchFieldException | InvocationTargetException |
                 NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println();

        //клонирование
        try {
            SingletonDog dog5 = (SingletonDog) originalDog.clone();

            System.out.println("originalDog == dog5: " + (originalDog == dog5));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
