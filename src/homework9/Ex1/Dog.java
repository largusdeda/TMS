package homework9.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
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
}
