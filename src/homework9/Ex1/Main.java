package homework9.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Собака"),
                new Tiger("Тигр"),
                new Rabbit("Кролик")
        };

        for (Animal animal : animals) {
            System.out.println("--- " + animal.getName() + " ---");

            animal.voice();

            animal.eat("мясо");
            animal.eat("кость");
            animal.eat("трава");
            animal.eat("морковь");
            animal.eat("рыба");
            animal.eat("камень");

            System.out.println();
        }
    }
}
