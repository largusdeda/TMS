package homework7.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Director extends Employee {
    public Director(String name, int expYears) {
        super(name, expYears);
    }

    @Override
    protected String getPositionTitle() {
        return "Директор";
    }
}
