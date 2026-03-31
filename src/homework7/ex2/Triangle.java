package homework7.ex2;

/**
 * @author Elena Chinarina
 *
 **/

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        //формула Герона
        double semiperimeter = calculatePerimeter() / 2;
        return Math.sqrt(semiperimeter *
                        (semiperimeter - sideA) *
                        (semiperimeter - sideB) *
                        (semiperimeter - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }
}
