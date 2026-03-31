package homework7.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Accountant extends Employee {
    public Accountant(String name, int expYears) {
        super(name, expYears);
    }

    @Override
    protected String getPositionTitle() {
        return "Бухгалтер";
    }
}
