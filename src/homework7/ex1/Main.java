package homework7.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Director director = new Director("Иван Иванов", 25);
        Worker worker = new Worker("Вася Пупкин", 8);
        Accountant accountant = new Accountant("У меня кончилась фантазия", 10);

        Employee[] employees = {director, worker, accountant};
        for (Employee employee : employees) {
            employee.printPosition();
            System.out.println();
        }
    }
}
