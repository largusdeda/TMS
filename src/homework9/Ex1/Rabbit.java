package homework9.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println(name + " тихо щелкает зубами");
    }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("трава") || food.equalsIgnoreCase("grass") ||
            food.equalsIgnoreCase("морковь") || food.equalsIgnoreCase("carrot") ||
            food.equalsIgnoreCase("капуста") || food.equalsIgnoreCase("cabbage")) {

            System.out.println(name + " с аппетитом ест \"" + food + "\"");

        } else if (food.equalsIgnoreCase("мясо") || food.equalsIgnoreCase("meat")) {
            System.out.println(name + " съел мясо, но это очень вредно");
        } else {
            System.out.println(name + " не хочет есть \"" + food + "\"");
        }
    }
}
