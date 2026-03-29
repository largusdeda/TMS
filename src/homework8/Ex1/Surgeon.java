package homework8.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Surgeon extends Doctor {
    @Override
    public void treat() {
        System.out.println("Хирург проводит операцию");
    }

    @Override
    public String toString() {
        return "Хирург";
    }
}
