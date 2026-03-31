package homework7.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public abstract class Employee implements PositionPrintable {
    protected String name;
    protected int expYears;

    public Employee(String name, int expYears) {
        this.name = name;
        this.expYears = expYears;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public int getExpYears() { return expYears; }
    public void setExpYears(int expYears) { this.expYears = expYears; }

    protected abstract String getPositionTitle();

    @Override
    public void printPosition() {
        System.out.println("Должность: " + getPositionTitle());
        System.out.println("Имя: " + name);
        System.out.println("Стаж работы: " + expYears);
    }
}
