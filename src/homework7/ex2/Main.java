package homework7.ex2;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Figure[] figures = {
                new Triangle(3, 4, 5),
                new Rectangle(6, 8),
                new Circle(5),
                new Rectangle(2.5, 4.5),
                new Triangle(7.7, 7.7, 7.7)
        };

        double totalPerimeter = 0;

        for (int i = 0; i < figures.length; i++) {
            System.out.println("Фигура " + (i + 1) + ": ");
            figures[i].displayInfo();
            totalPerimeter += figures[i].calculatePerimeter();
        }

        System.out.printf("Периметр всех фигур: %.2f",  totalPerimeter);
    }
}
