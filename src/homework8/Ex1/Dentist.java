package homework8.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Dentist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Дантист лечит зубы");
    }

    @Override
    public String toString() {
        return "Дантист";
    }
}
