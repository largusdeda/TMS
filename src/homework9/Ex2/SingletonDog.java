package homework9.Ex2;

import java.io.Serializable;

/**
 * @author Elena Chinarina
 *
 **/

public class SingletonDog extends Animal implements Serializable, Cloneable {
    private static SingletonDog instance;

    private SingletonDog(String name) {
        super(name);
    }

    public static SingletonDog getInstance(String name) {
        if (instance == null) {
            instance = new SingletonDog(name);
        }
        return instance;
    }

    @Override
    public void voice() {
        System.out.println(name + " говорит: \"Гав-гав!\"");
    }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("мясо") || food.equalsIgnoreCase("meat")) {
            System.out.println(name + " с удовольствием ест мясо");
        } else if (food.equalsIgnoreCase("кость") || food.equalsIgnoreCase("bone")) {
            System.out.println(name + " грызет косточку");
        } else {
            System.out.println(name + " не хочет есть \"" + food + "\"");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
