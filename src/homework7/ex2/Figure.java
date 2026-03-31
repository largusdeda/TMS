package homework7.ex2;

/**
 * @author Elena Chinarina
 *
 **/

public abstract class Figure {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public void displayInfo() {
        System.out.println(getClass().getSimpleName() +
                ": Площадь = " + String.format("%.2f", calculateArea()) +
                ", периметр = " + String.format("%.2f", calculatePerimeter()));
    }
}
