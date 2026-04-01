package homework9.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Tiger extends Animal {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println(name + " фыркает");
    }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("мясо") || food.equalsIgnoreCase("meat")) {
            System.out.println(name + " жадно ест мясо");
        } else if (food.equalsIgnoreCase("кость") || food.equalsIgnoreCase("bone")) {
            System.out.println(name + " грызет кость");
        } else if (food.equalsIgnoreCase("рыба") || food.equalsIgnoreCase("fish")) {
            System.out.println(name + " с удовольствием ест рыбу");
        } else {
            System.out.println(name + " не хочет есть \"" + food + "\"");
        }
    }
}
