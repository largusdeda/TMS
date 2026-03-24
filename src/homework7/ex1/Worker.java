package homework7.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Worker extends Employee {
    public Worker(String name, int expYears) {
        super(name, expYears);
    }

    @Override
    protected String getPositionTitle() {
        return "Рабочий";
    }
}
